package com.automationexercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

public class BrowserManager {

    public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {

            String pathExtension = PropertiesLoader.loadProperty("chrome.extension.adblock.path");

            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("load-extension=" + pathExtension); //uBlock Origin
            //chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            driver = new FirefoxDriver(firefoxOptions);

            ((FirefoxDriver) driver).installExtension(
                    new File("C:\\Users\\iamGa\\Downloads\\ublock_origin-1.74.0.xpi").toPath()
            );
        }
        return driver;
    }
}