package com.automationexercise.pages;

import com.automationexercise.utils.JSONReader;
import com.automationexercise.utils.SeleniumHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

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

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProduct1Button;

    public HomePage(WebDriver driver) {
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;

    @FindBy(id = "success-subscribe")
    private WebElement alertSuccessSubscribe;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    public WebElement homePageIsVisible() {
        System.out.println(driver);
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
    public WebElement getSubscription() {
        return subscription;
    }

    public ProductsPage productsButtonClick() {

        SeleniumHelper.waitForElementToBeClickable(driver, productsButton);
        System.out.println(productsButton.isDisplayed());
        productsButton.click();
        return new ProductsPage(driver);
    }
    public ProductDetailPage viewProduct1ButtonClick() {
        SeleniumHelper.waitForElementToBeClickable(driver, viewProduct1Button);
        viewProduct1Button.click();
        return new ProductDetailPage(driver);
    }
    public HomePage fillSubscribe() throws IOException, ParseException {
        subscribeEmailInput.sendKeys(JSONReader.existingUser("email"));
        SeleniumHelper.waitForElementToBeClickable(driver, subscribeButton);
        subscribeButton.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }

    public CartPage cartButtonClick() {
        cartButton.click();
        return new CartPage(driver);
    }


}