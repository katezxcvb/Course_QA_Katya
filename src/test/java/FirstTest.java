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
import org.example.MainPage;
import org.example.PaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class FirstTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkBlockTitle() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();

        String expected = "Онлайн пополнение без комиссии";
        String actual = mainPage.getBlockTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void testPaymentLogos() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();

        String[] logos = {
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        };

        for (String alt : logos) {
            assertTrue(mainPage.isPaymentLogoVisible(alt), "Логотип не найден: " + alt);
        }
    }

    @Test
    public void testDetailsLink() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();

        mainPage.clickDetails();

        String url = mainPage.getCurrentUrl();
        assertTrue(url.contains("help") || url.contains("opl") || url.contains("pay"));
    }

    @Test
    public void testFormAndContinue() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();

        mainPage.fillPhone("297777777");
        mainPage.fillAmount("456");
        mainPage.fillEmail("ekhmelevskay15@gmail.com");
        mainPage.clickContinue();

        PaymentPage paymentPage = new PaymentPage(driver);

        assertTrue(paymentPage.waitForPaymentPage(),
                "URL не изменился — переход на страницу оплаты не выполнен");

        assertTrue(paymentPage.isCloseButtonVisible(),
                "Окно оплаты не появилось — кнопка закрытия не найдена");

        paymentPage.closePaymentWindow();

        System.out.println("Тест пройден: окно оплаты появилось и было успешно закрыто.");
    }



    // Тесты для проверки вариантов оплаты услуг
    @Test
    public void testPlaceholdersMobile() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();
        mainPage.openMobileTab();

        assertEquals("Номер телефона", mainPage.getPhonePlaceholder());
        assertEquals("Сумма", mainPage.getAmountPlaceholder());
        assertEquals("Email для чека", mainPage.getEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersHomeInternet() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();
        mainPage.openHomeInternetTab();

        assertEquals("Номер договора", mainPage.getPhonePlaceholder());
        assertEquals("Сумма", mainPage.getAmountPlaceholder());
        assertEquals("Email для чека", mainPage.getEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersInstallment() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();
        mainPage.openInstallmentTab();

        assertEquals("Номер договора", mainPage.getPhonePlaceholder());
        assertEquals("Сумма", mainPage.getAmountPlaceholder());
        assertEquals("Email для чека", mainPage.getEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersDebt() {
        mainPage.open();
        mainPage.closeCookiesIfPresent();
        mainPage.openDebtTab();

        assertEquals("Номер телефона", mainPage.getPhonePlaceholder());
        assertEquals("Email для чека", mainPage.getEmailPlaceholder());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
