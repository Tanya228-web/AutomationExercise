package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utils.Util;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase1 extends TestBase {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 1: Register User")
    public void registerUser() throws IOException, ParseException {

        verifyThatHomePageIsVisibleSuccessfully();

    }

    public static void verifyThatHomePageIsVisibleSuccessfully() {

        boolean homePageVisible = new HomePage(getDriver())
                .homePageIsVisible()
                .isDisplayed();

        Assert.assertTrue(
                homePageVisible,
                "Verify that home page is not visible successfully"
        );
    }

}