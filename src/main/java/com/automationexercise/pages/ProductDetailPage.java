package com.automationexercise.pages;

import com.automationexercise.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    WebDriver driver;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(css = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(css = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    public ProductDetailPage(WebDriver driver) {
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public ProductDetailPage increaseQuantity(String value) {
        quantityInput.clear();
        quantityInput.sendKeys(value);
        return this;
    }
    public ProductDetailPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }
    public CartPage viewCartButtonClick() {
        SeleniumHelper.waitForElementToBeClickable(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }
}
