import org.example.MainTopUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.MainTopUpPage;
import org.example.PaymentPage;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObjectMts {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPlaceholdersAllForms() throws InterruptedException {
        driver.get("https://www.mts.by/");
        MainTopUpPage page = new MainTopUpPage(driver);

        page.closeCookiesIfPresent();
        Thread.sleep(2000);

        // Услуги связи
        page.openConnection();
        assertEquals("Номер телефона", page.getPhonePlaceholder());
        assertEquals("Сумма", page.getSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getEmailPlaceholder());

        // Домашний интернет
        page.openInternet();
        assertEquals("Номер абонента", page.getPhonePlaceholder());
        assertEquals("Сумма", page.getSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getEmailPlaceholder());

        // Рассрочка
        page.openInstalment();
        assertEquals("Номер счета на 44", page.getPhonePlaceholder());
        assertEquals("Сумма", page.getSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getEmailPlaceholder());

        // Задолженность
        page.openArrears();
        assertEquals("Номер счета на 2073", page.getPhonePlaceholder());
        assertEquals("Сумма", page.getSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getEmailPlaceholder());
    }

    @Test
    public void testConnectionPaymentFlow() throws InterruptedException {
        driver.get("https://www.mts.by/");
        MainTopUpPage page = new MainTopUpPage(driver);

        Thread.sleep(2000);

        // Открываем вкладку
        page.openConnection();

        // Заполняем форму
        page.fillConnectionForm("297777777", "456", "ekhmelevskay15@gmail.com");

        // Переходим к оплате
        page.clickContinue();
        Thread.sleep(3000);

        PaymentPage payment = new PaymentPage(driver);

        assertTrue(payment.isOpened(), "Окно оплаты не открылось");

        // Проверяем сумму
        assertTrue(payment.getSumHeader().contains("456"), "Сумма в заголовке неверная");
        assertTrue(payment.getSumButton().contains("456"), "Сумма на кнопке неверная");

        // Проверяем номер телефона
        assertTrue(payment.getPhone().contains("297777777"), "Телефон отображается неверно");

        // Проверяем плейсхолдеры карты
        assertEquals("Номер карты", payment.getCardNumberPlaceholder());
        assertEquals("MM/YY", payment.getCardExpiryPlaceholder());
        assertEquals("CVC", payment.getCardCvcPlaceholder());
        assertEquals("Имя и фамилия на карте", payment.getCardNamePlaceholder());

        // Проверяем наличие логотипов
        assertTrue(payment.getPaymentLogosCount() >= 2, "Логотипы платёжных систем отсутствуют");
    }


}

