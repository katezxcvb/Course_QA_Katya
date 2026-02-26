package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

    private final By closeButton = By.cssSelector(".header__close-button");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean waitForPaymentPage() {
        return wait.until(ExpectedConditions.urlContains("payment"));
    }

    public boolean isCloseButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).isDisplayed();
    }

    public void closePaymentWindow() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

}
