package less9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.NoSuchElementException;

class AppTest extends TestBase {

    // 1. Проверка названия блока
    @Test
    void testBlockTitle() {
        WebElement title = driver.findElement(
                By.xpath("//div[@class='pay__wrapper']//h2")
        );

        assertTrue(title.isDisplayed(), "Заголовок блока не найден");
        String actualText = title.getText()
                .replace("\n", " ")
                .replace("\r", " ")
                .replaceAll("\\s+", " ")
                .trim();
        assertEquals("Онлайн пополнение без комиссии", actualText);
    }

    // 2. Проверка логотипов платёжных систем
    @Test
    void testPaymentLogos() {
        String[] logoAlts = {
                "Visa",
                "Verified Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        };

        for (String alt : logoAlts) {
            WebElement logo = driver.findElement(By.xpath("//img[@alt='" + alt + "']"));
            assertTrue(logo.isDisplayed(), "Логотип не найден: " + alt);
        }
    }

    // 3. Проверка ссылки «Подробнее о сервисе»
    @Test
    void testDetailsLink() throws InterruptedException {
        try {
            WebElement cookiesBtn = driver.findElement(
                    By.xpath("//button[contains(text(),'Принять') " +
                            "or contains(text(),'Согласиться')]")
            );
            cookiesBtn.click();
            Thread.sleep(1000);
        } catch (NoSuchElementException ignored) {
        }

        WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        link.click();
        Thread.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("about"),
                "Ссылка 'Подробнее о сервисе' не открыла нужную страницу");
    }


    // 4. Заполнение формы и проверка кнопки «Продолжить»
    @Test
    void testFormAndContinue() throws InterruptedException {
        WebElement serviceSelect = driver.findElement(By.id("connection-type"));
        serviceSelect.click();
        serviceSelect.sendKeys("Услуги связи");

        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.click();
        phone.sendKeys("297777777");

        WebElement amount = driver.findElement(By.id("connection-sum"));
        amount.click();
        amount.sendKeys("5");

        WebElement email = driver.findElement(By.id("connection-email"));
        email.click();
        email.sendKeys("test@test.com");

        WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueBtn.click();

        Thread.sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("pay"),
                "После нажатия 'Продолжить' не открылся платёжный шаг");
    }
}
