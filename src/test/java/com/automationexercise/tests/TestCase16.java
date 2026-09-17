package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoggedHomePage;
import com.automationexercise.utils.JSONReader;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationexercise.tests.TestBase.getDriver;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase16 extends TestBase {

    @Test(description = "Test Case 16: Place Order: Login before Checkout")
    public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver())
                .signupLoginClick()
                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        verifyLoggedInAsUsernameAtTop();
        TestCase14.verifyThatCartPageIsDisplayed();
        new CartPage(getDriver()).proceedToCheckoutButtonClick();
        TestCase14.verifyAddressDetailsAndReviewYourOrder();
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
    }

    @Step("Verify 'Logged in as username' at top")
    private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
        String username = new LoggedHomePage(getDriver())
                .getUsername()
                .getText();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify 'Logged in as username' at top");
    }
}