package com.automationexercise.pages;

import com.automationexercise.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    @FindBy(css = ".title.text-center")
    private WebElement titleTextCenter;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    public ProductsPage(WebDriver driver) {
        System.out.println(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement getTitleTextCenter() {

        SeleniumHelper.waitForElementToBeVisible(driver, titleTextCenter);
        return titleTextCenter;
    }
    public ProductDetailsPage viewProductOfFirstProductButtonClick() {
        viewProductOfFirstProductButton.click();
        return new ProductDetailsPage(driver);
    }
}
