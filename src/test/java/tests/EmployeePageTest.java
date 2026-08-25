package tests;

import basepackage.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeePageTest extends BaseTest {

    @Test(
            priority = 3,
            description = "Verify employee page",
            groups = {"sanity", "employee"},
            dependsOnGroups = {"dashboard"}
    )
    public void verifyEmployeePage() {

        System.out.println("===== Employee Page Test Started =====");

        // Click Employees
        driver.findElement(
                By.cssSelector("a[href='/Employee']")
        ).click();

        // Verify page title
        String title = driver.getTitle();

        System.out.println("Page Title = " + title);

        Assert.assertEquals(
                title,
                "Employee List - EAEmployee",
                "Employee page title is incorrect"
        );

        // Verify Employee page URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL = " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("/Employee"),
                "Employee page URL is incorrect"
        );

        System.out.println("Employee page verified successfully");

        System.out.println("===== Employee Page Test Completed =====");
    }
}