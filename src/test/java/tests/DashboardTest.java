package tests;

import basepackage.BaseTest;
import listeners.RetryAnalyzer;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(
            priority = 2,
            description = "Verify Dashboard page",
            groups = {"smoke", "dashboard"},
            dependsOnGroups = {"login"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void verifyDashboard() {

        System.out.println("===== Dashboard Test Started =====");

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        // Dashboard page
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        // Verify title
        String title = dashboardPage.getPageTitle();

        System.out.println("Dashboard Title = " + title);

        Assert.assertEquals(
                title,
                "Home - EAEmployee",
                "Dashboard title is incorrect"
        );

        // Verify URL
        String currentUrl = dashboardPage.getCurrentUrl();

        System.out.println("Dashboard URL = " + currentUrl);

        Assert.assertEquals(
                currentUrl,
                ConfigReader.getProperty("url"),
                "Dashboard URL is incorrect"
        );

        // Verify dashboard
        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed"
        );

        System.out.println("Dashboard verified successfully");

        System.out.println("===== Dashboard Test Completed =====");
    }
}