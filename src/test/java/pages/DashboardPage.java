package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isDashboardDisplayed() {

        return driver.getTitle()
                .equals("Home - EAEmployee");
    }
}