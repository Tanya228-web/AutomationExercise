package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }
}