package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    private WebDriver driver;

    // Locators
    private By employeeLink =
            By.cssSelector("a[href='/Employee']");

    // Constructor
    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickEmployee() {
        driver.findElement(employeeLink).click();
    }

    // Page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Verify Employee page
    public boolean isEmployeePageDisplayed() {

        return driver.getTitle()
                .equals("Employee List - EAEmployee");
    }
}