package com.automationexercise.tests;

import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.tests.TestBase.getDriver;

public class TestCase9 extends TestBase {

    static String search;

    static {
        try {
            search = PropertiesLoader.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void searchProduct() {

        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifySearchedProductsIsVisible();
        //verifyAllTheProductsRelatedToSearchAreVisible();
    }
    public static void verifySearchedProductsIsVisible() {
        String searchedProductsText = new ProductsPage(getDriver())
                .fillSearchProductInput(search)
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");
    }
}
