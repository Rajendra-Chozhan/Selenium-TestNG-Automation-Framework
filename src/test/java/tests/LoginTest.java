package tests;

import basepackage.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class LoginTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Verify user can login successfully",
            groups = {"smoke", "login"}
    )
    public void loginTest() throws InterruptedException {

        System.out.println("===== Login Test Started =====");

        // Click Login
        driver.findElement(By.linkText("Login")).click();

        // Enter username
        driver.findElement(By.id("UserName"))
                .sendKeys("rajchozhan024@gmail.com");

        // Enter password
        driver.findElement(By.id("Password"))
                .sendKeys("Ea@761645");

        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        // Verify title
        String title = driver.getTitle();

        System.out.println("Page Title = " + title);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assert.assertEquals(
                title,
                "Home - EAEmployee",
                "Title differs after login"
        );

        // Verify URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL = " + currentUrl);

        Assert.assertEquals(
                currentUrl,
                "https://eaapp.somee.com/",
                "Home page URL is incorrect"
        );

        System.out.println("Login successful");

        System.out.println("===== Login Test Completed =====");
    }
}