package tests;

import basepackage.BaseTest;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import java.time.Duration;


public class LogoutTest extends BaseTest {

    @Test(
            priority = 4,
            description = "Verify logout functionality",
            groups = {"sanity", "logout"},
            dependsOnGroups = {"employee"}
    )
    public void logoutTest() {

        System.out.println("===== Logout Test Started =====");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click Logout
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();

       System.out.println("Logout successful");
    }
}