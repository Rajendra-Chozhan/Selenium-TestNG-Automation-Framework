package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By loginLink = By.linkText("Login");
    private By username = By.id("UserName");
    private By password = By.id("Password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String usernameValue) {
        driver.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        driver.findElement(password).sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String usernameValue, String passwordValue) {

        clickLogin();
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLoginButton();
    }
}