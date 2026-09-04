package com.automationexercise.tests;

import com.automationexercise.pages.LoggedHomePage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("User")
public class TestCase4 extends TestBase {

    @Test
    public void logoutUser() throws IOException, ParseException {
        TestCase2.loginUserWithCorrectEmailAndPassword();
        verifyThatUserIsNavigatedToLoginPage();
    }

    private void verifyThatUserIsNavigatedToLoginPage() {
        String loginToYourAccountText = new LoggedHomePage(getDriver())
                .logoutButtonClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
    }
}