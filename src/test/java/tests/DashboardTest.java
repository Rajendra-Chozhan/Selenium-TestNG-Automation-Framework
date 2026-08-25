package tests;

import basepackage.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(
            priority = 2,
            description = "Verify Dashboard page",
            groups = {"smoke", "dashboard"},
            dependsOnGroups = {"login"}
    )
    public void verifyDashboard() {

        System.out.println("===== Dashboard Test Started =====");

        // Verify Dashboard/Home page title
        String title = driver.getTitle();


        // Click Employees
        driver.findElement(By.cssSelector("a[href='/Home/Dashboard']")).click();


        String heading = driver.getTitle();
        System.out.println(heading);

        Assert.assertEquals(
                heading,
                "Dashboard - EAEmployee",
                "Dashboard - EAEmployee heading is incorrect"
        );

        System.out.println("Dashboard - EAEmployee page verified successfully");
    }
}