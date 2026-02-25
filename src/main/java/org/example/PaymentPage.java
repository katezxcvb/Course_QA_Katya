package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private final WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Контейнер Angular-страницы оплаты
    private final By paymentContainer = By.xpath("//app-payment-container");

    // Сумма в заголовке
    private final By sumHeader = By.xpath("//*[contains(@class,'payment')]//*[contains(text(),'BYN')]");

    // Сумма на кнопке
    private final By sumButton = By.xpath("//button[contains(text(),'Оплатить')]");

    // Телефон
    private final By phoneText = By.xpath("//*[contains(text(),'375')]");

    // Поля карты
    private final By cardNumber = By.xpath("//input[@placeholder='Номер карты']");
    private final By cardExpiry = By.xpath("//input[@placeholder='MM/YY']");
    private final By cardCvc = By.xpath("//input[@placeholder='CVC']");
    private final By cardName = By.xpath("//input[@placeholder='Имя и фамилия на карте']");

    // Логотипы платёжных систем
    private final By paymentLogos = By.xpath("//img[contains(@src,'visa') or contains(@src,'master')]");

    public boolean isOpened() {
        return driver.findElement(paymentContainer).isDisplayed();
    }

    public String getSumHeader() {
        return driver.findElement(sumHeader).getText();
    }

    public String getSumButton() {
        return driver.findElement(sumButton).getText();
    }

    public String getPhone() {
        return driver.findElement(phoneText).getText();
    }

    public String getCardNumberPlaceholder() {
        return driver.findElement(cardNumber).getAttribute("placeholder");
    }

    public String getCardExpiryPlaceholder() {
        return driver.findElement(cardExpiry).getAttribute("placeholder");
    }

    public String getCardCvcPlaceholder() {
        return driver.findElement(cardCvc).getAttribute("placeholder");
    }

    public String getCardNamePlaceholder() {
        return driver.findElement(cardName).getAttribute("placeholder");
    }

    public int getPaymentLogosCount() {
        return driver.findElements(paymentLogos).size();
    }
}
