package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationexercise.tests.TestBase.getDriver;

public class TestCase7 extends TestBase {

    @Test
    public void verifyTestCasesPage() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToTestCasesPageSuccessfully();
    }

    @Step("Verify user is navigated to test cases page successfully")
    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        String testCasesText = new HomePage(getDriver())
                .testCasesButtonClick()
                .getTestCases()
                .getText();
        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
    }
}