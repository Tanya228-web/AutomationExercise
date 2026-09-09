package com.automationexercise.pages;

import com.automationexercise.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {

    WebDriver driver;

    @FindBy(css = ".title.text-center")
    private WebElement titleTextCenter;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    @FindBy(id = "search_product")
    private WebElement searchProductInput;

    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
    private List<WebElement> searchResultsNames;


    @FindBy(id = "submit_search")
    private WebElement submitSearchInput;


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
    public ProductsPage fillSearchProductInput(String searchProduct) {
        searchProductInput.sendKeys(searchProduct);
        submitSearchInput.click();
        return this;
    }
    public List<String> getProductsSearchNames() {
        return searchResultsNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
