package tests;

import basepackage.BaseTest;
import listeners.RetryAnalyzer;
import pages.LoginPage;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Verify user can login successfully",
            groups = {"smoke", "login"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void loginTest() {

        System.out.println("===== Login Test Started =====");

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Read username and password from config.properties
        String username =
                ConfigReader.getProperty("username");

        String password =
                ConfigReader.getProperty("password");

        // Login
        loginPage.login(username, password);

        // Verify page title
        String title = driver.getTitle();

        System.out.println("Page Title = " + title);

        Assert.assertEquals(
                title,
                "Home - EAEmployee",
                "Title differs after login"
        );

        // Verify URL
        String currentUrl = driver.getCurrentUrl();

        String expectedUrl =
                ConfigReader.getProperty("url");

        System.out.println("Current URL = " + currentUrl);

        Assert.assertEquals(
                currentUrl,
                expectedUrl,
                "Home page URL is incorrect"
        );

        System.out.println("Login successful");

        System.out.println("===== Login Test Completed =====");
    }
}