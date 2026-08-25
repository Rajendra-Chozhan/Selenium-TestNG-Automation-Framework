package basepackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {

        // Launch Chrome
        driver = new ChromeDriver();

        // Implicit wait
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Maximize browser
        driver.manage().window().maximize();

        // Read URL from config.properties
        String url = ConfigReader.getProperty("url");

        // Open application
        driver.get(url);

        System.out.println("===== Browser Started =====");
        System.out.println("Current URL = " + driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();

            System.out.println("===== Browser Closed =====");
        }
    }
}