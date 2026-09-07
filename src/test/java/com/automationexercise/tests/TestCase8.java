package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 extends TestBase{

    @Test
    public void verifyAllProductsAndProductDetailPage() {

        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToAllProductsPageSuccessfully();
        new ProductsPage(getDriver()).viewProductOfFirstProductButtonClick();
        verifyThatDetailDetailIsVisible();
    }
    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully(){

        String allProductsText = new HomePage(getDriver())
                .productsButtonClick()
                .getTitleTextCenter()
                .getText();
            Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
        }

    private void verifyThatDetailDetailIsVisible() {
        boolean name = new ProductDetailsPage(getDriver()).getProductName().isDisplayed();
        boolean category = new ProductDetailsPage(getDriver()).getProductCategory().isDisplayed();
        boolean price = new ProductDetailsPage(getDriver()).getProductPrice().isDisplayed();
        boolean availability = new ProductDetailsPage(getDriver()).getProductAvailability().isDisplayed();
        boolean condition = new ProductDetailsPage(getDriver()).getProductCondition().isDisplayed();
        boolean brand = new ProductDetailsPage(getDriver()).getProductBrand().isDisplayed();

        Assert.assertTrue(name, "Verify that detail detail is visible: name");
        Assert.assertTrue(category, "Verify that detail detail is visible: category");
        Assert.assertTrue(price, "Verify that detail detail is visible: price");
        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
    }



}
