package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainTopUpPage {

    private final WebDriver driver;

    public MainTopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Вкладки
    private final By tabConnection = By.xpath("//span[@class='select__now' and text()='Услуги связи']/parent::button");
    private final By tabInternet = By.xpath("//span[@class='select__now' and text()='Домашний интернет']/parent::button");
    private final By tabInstalment = By.xpath("//span[@class='select__now' and text()='Рассрочка']/parent::button");
    private final By tabArrears = By.xpath("//span[@class='select__now' and text()='Задолженность']/parent::button");

    // Поля
    private final By phoneField = By.id("connection-phone");
    private final By sumField = By.id("connection-sum");
    private final By emailField = By.id("connection-email");

    // Методы переключения вкладок
    public void openConnection() {
        driver.findElement(tabConnection).click();
    }

    public void openInternet() {
        driver.findElement(tabInternet).click();
    }

    public void openInstalment() {
        driver.findElement(tabInstalment).click();
    }

    public void openArrears() {
        driver.findElement(tabArrears).click();
    }


    // Методы получения плейсхолдеров
    public String getPhonePlaceholder() {
        return driver.findElement(phoneField).getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return driver.findElement(sumField).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailField).getAttribute("placeholder");
    }
    public void fillConnectionForm(String phone, String sum, String email) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(sumField).clear();
        driver.findElement(sumField).sendKeys(sum);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
    }

    public void closeCookiesIfPresent() {
        try {
            WebElement cookieBtn = driver.findElement(By.xpath("//div[contains(@class,'cookie')]//button"));
            cookieBtn.click();
            Thread.sleep(500);
        } catch (Exception ignored) {}
    }

}
