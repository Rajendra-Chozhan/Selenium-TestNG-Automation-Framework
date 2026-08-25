package tests;

import basepackage.BaseTest;
import listeners.RetryAnalyzer;
import pages.LoginPage;
import pages.LogoutPage;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(
            priority = 4,
            description = "Verify logout functionality",
            groups = {"sanity", "logout"},
            dependsOnGroups = {"login"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void logoutTest() {

        System.out.println("===== Logout Test Started =====");

        // Login first because BaseTest creates a fresh browser
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        // Create Logout Page object
        LogoutPage logoutPage = new LogoutPage(driver);


        // Click Logout
        logoutPage.clickLogout();
        System.out.println("Logout successful");

        logoutPage.isLoginPageDisplayed();

        System.out.println("===== Logout Test Completed =====");
    }
}