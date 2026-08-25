package basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    // Runs once before all test methods in the class
    @BeforeClass
    public void setup() {

        System.out.println("===== BeforeClass : Browser Setup =====");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://eaapp.somee.com/");

        System.out.println("Browser launched");
        System.out.println("URL = " + driver.getCurrentUrl());
    }


    // Runs before every @Test method
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("===== BeforeMethod =====");
        System.out.println("Starting test...");
    }


    // Runs after every @Test method
    @AfterMethod
    public void afterMethod() {

        System.out.println("===== AfterMethod =====");
        System.out.println("Test completed");
    }


    // Runs once after all test methods in the class
    @AfterClass(alwaysRun = true)
    public void tearDown() {

        System.out.println("===== AfterClass =====");

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }
}