package com.automationexercise.pages;

import com.automationexercise.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;

    public HomePage(WebDriver driver) {
        System.out.println(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }
    public LoginSignupPage signupLoginClick() {
        signupLoginButton.click();
        return new LoginSignupPage(driver);
    }
    public ContactUsPage contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }
    public TestCasesPage testCasesButtonClick() {
        testCasesButton.click();
        return new TestCasesPage(driver);
    }
    public ProductsPage productsButtonClick() {
        System.out.println(productsButton.isDisplayed());
        productsButton.click();
        return new ProductsPage(driver);
    }


}