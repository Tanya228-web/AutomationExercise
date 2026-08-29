package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {
    private WebDriver driver;



    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignup;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;


    public LoginSignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNewUserSignup() {
        return newUserSignup;
    }
    private void fillSignup(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
    }
    public EnterAccountInformationPage fillCorrectSignup(String name, String email) {
        fillSignup(name, email);
        return new EnterAccountInformationPage(driver);
    }
}
