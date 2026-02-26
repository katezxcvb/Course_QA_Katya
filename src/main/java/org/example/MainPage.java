package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private final By paymentLogos = By.xpath("//img[@alt='%s']");
    private final By detailsLink = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private final By cookiesBtn = By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласиться')]");

    private final By phoneField = By.id("connection-phone");
    private final By amountField = By.id("connection-sum");
    private final By emailField = By.id("connection-email");
    private final By continueBtn = By.xpath("//button[contains(text(),'Продолжить')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void closeCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookiesBtn)).click();
        } catch (Exception ignored) {}
    }

    public String getBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public boolean isPaymentLogoVisible(String alt) {
        By locator = By.xpath(String.format("//img[@alt='%s']", alt));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public void clickDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
    }

    public void fillPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void fillAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField)).sendKeys(amount);
    }

    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    // --- ЗАДАНИЕ 2.10  ---

    // Вкладки
    private final By tabMobile = By.xpath("//button[contains(text(),'Услуги связи')]");
    private final By tabHomeInternet = By.xpath("//button[contains(text(),'Домашний интернет')]");
    private final By tabInstallment = By.xpath("//button[contains(text(),'Рассрочка')]");
    private final By tabDebt = By.xpath("//button[contains(text(),'Задолженность')]");

    // Поля (внутри разных вкладок ID одинаковые)
    private final By fieldPhone = By.id("connection-phone");
    private final By fieldAmount = By.id("connection-sum");
    private final By fieldEmail = By.id("connection-email");

    // Универсальный метод получения placeholder
    public String getPlaceholder(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getAttribute("placeholder");
    }

    // Методы переключения вкладок
    public void openMobileTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabMobile)).click();
    }

    public void openHomeInternetTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabHomeInternet)).click();
    }

    public void openInstallmentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabInstallment)).click();
    }

    public void openDebtTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabDebt)).click();
    }

    // Методы получения placeholder-ов
    public String getPhonePlaceholder() {
        return getPlaceholder(fieldPhone);
    }

    public String getAmountPlaceholder() {
        return getPlaceholder(fieldAmount);
    }

    public String getEmailPlaceholder() {
        return getPlaceholder(fieldEmail);
    }

}
