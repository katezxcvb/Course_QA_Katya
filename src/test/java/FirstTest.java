import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //1.Проверка названия блока
    @Test
    public void checkBlockTitle() throws InterruptedException {
        driver.get("https://www.mts.by/");

        // Даем странице прогрузиться (лучше заменить на WebDriverWait)
        Thread.sleep(3000);

        String expectedTitle = "Онлайн пополнение без комиссии";

        WebElement title = driver.findElement(
                By.xpath("//div[@class='pay__wrapper']//h2")
        );

        assertTrue(title.isDisplayed(), "Заголовок блока не найден");

        String actualText = title.getText()
                .replace("\n", " ")
                .replace("\r", " ")
                .replaceAll("\\s+", " ")
                .trim();

        assertEquals(expectedTitle, actualText, "Заголовок блока неверный");
        System.out.println("Тест пройден: заголовок блока отображается корректно");

    }

    // 2. Проверка логотипов платёжных систем
    @Test
    public void testPaymentLogos() throws InterruptedException {
        driver.get("https://www.mts.by/");

        Thread.sleep(5000);

        String[] logoAlts = {
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        };

        for (String alt : logoAlts) {
            WebElement logo = driver.findElement(By.xpath("//img[@alt='" + alt + "']"));
            assertTrue(logo.isDisplayed(), "Логотип не найден: " + alt);
        }

        System.out.println("Тест пройден: все логотипы платёжных систем отображаются корректно");
    }

    // 3. Проверка ссылки «Подробнее о сервисе»
    @Test
    public void testDetailsLink() throws InterruptedException {
        driver.get("https://www.mts.by/");

        // Закрываем cookies, если появятся
        try {
            WebElement cookiesBtn = driver.findElement(
                    By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласиться')]")
            );
            cookiesBtn.click();
            Thread.sleep(1000);
        } catch (NoSuchElementException ignored) {
        }

        WebElement link = driver.findElement(
                By.xpath("//a[contains(text(),'Подробнее о сервисе')]")
        );

        assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не найдена");

        link.click();
        Thread.sleep(2000);

        String current = driver.getCurrentUrl();

        assertTrue(
                current.contains("help") || current.contains("opl") || current.contains("pay"),
                "Ссылка 'Подробнее о сервисе' не открыла нужную страницу. Открыто: " + current
        );

        System.out.println("Тест пройден: ссылка 'Подробнее о сервисе' работает корректно");
    }

    //4.Проверка кнопки "Продолжить"
    @Test
    public void testFormAndContinue() throws InterruptedException {
        driver.get("https://www.mts.by/");

        Thread.sleep(3000);

        // Закрываем cookies, если появятся
        try {
            WebElement cookiesBtn = driver.findElement(
                    By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласиться')]")
            );
            cookiesBtn.click();
            Thread.sleep(500);
        } catch (NoSuchElementException ignored) {}

        // Заполняем номер телефона
        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.clear();
        phone.sendKeys("297777777");

        // Заполняем сумму
        WebElement amount = driver.findElement(By.id("connection-sum"));
        amount.clear();
        amount.sendKeys("456");

        // Заполняем email
        WebElement email = driver.findElement(By.id("connection-email"));
        email.clear();
        email.sendKeys("ekhmelevskay15@gmail.com");

        // Нажимаем кнопку "Продолжить"
        WebElement continueBtn = driver.findElement(
                By.xpath("//button[contains(text(),'Продолжить')]")
        );
        continueBtn.click();

        Thread.sleep(3000);

        // Проверяем появление Angular-страницы оплаты
        WebElement paymentPage = driver.findElement(
                By.xpath("//div[contains(@class,'app-wrapper__content-container')]//app-payment-container")
        );

        assertTrue(paymentPage.isDisplayed(),
                "После нажатия 'Продолжить' не открылась страница оплаты (app-payment-container)");

        System.out.println("Тест пройден: страница оплаты успешно открывается");
    }




    @AfterEach
    public void tearDown(){
        driver .quit();
    }
}
