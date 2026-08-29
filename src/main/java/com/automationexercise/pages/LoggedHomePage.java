package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    private WebElement username;

    public LoggedHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountButton;

    public WebElement getUsername() {
        return username;
    }
    public AccountDeletedPage deleteAccountButtonClick() {
        deleteAccountButton.click();
        return new AccountDeletedPage(driver);
    }
}
