package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    private WebDriver driver;

    private By logoutLink = By.xpath("//button[contains(text(),'Logout')]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isLoginPageDisplayed() {

        return driver.findElement(
                By.linkText("Login")
        ).isDisplayed();
    }
}