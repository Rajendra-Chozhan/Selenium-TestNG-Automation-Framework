package tests;

import basepackage.BaseTest;
import listeners.RetryAnalyzer;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeePageTest extends BaseTest {

    @Test(
            priority = 3,
            description = "Verify Employee page",
            groups = {"sanity", "employee"},
            dependsOnGroups = {"login"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void verifyEmployeePage() {

        System.out.println("===== Employee Page Test Started =====");

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        // Employee page
        EmployeePage employeePage =
                new EmployeePage(driver);

        employeePage.clickEmployee();

        // Verify title
        String title = employeePage.getPageTitle();

        System.out.println("Employee Page Title = " + title);

        Assert.assertEquals(
                title,
                "Employee List - EAEmployee",
                "Employee page title is incorrect"
        );

        // Verify page
        Assert.assertTrue(
                employeePage.isEmployeePageDisplayed(),
                "Employee page is not displayed"
        );

        System.out.println(
                "Employee page verified successfully"
        );

        System.out.println("===== Employee Page Test Completed =====");
    }
}