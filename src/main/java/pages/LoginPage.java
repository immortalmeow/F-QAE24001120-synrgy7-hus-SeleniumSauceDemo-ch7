package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //class u/ masing2 element
    By usernameField = By.name("user-name");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//*[@id=\"login-button\"]");
    By loginText = By.xpath("//*[@id=\"root\"]/div/div[1]");
    By errorText = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By passwordcrossButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        // set explicit wait selama 15 detik
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //create method untuk action
    public void inputUsername( String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);

    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();

    }
    public String getcurrentURL(){
        return driver.getCurrentUrl();
    }
    public String getTittle(){
        return driver.findElement(loginText).getText();
    }
    public String getErrorText(){
        return driver.findElement(errorText).getText();
    }
    public void passwordcrossButtonIsDisplayed(){
        driver.findElement(passwordcrossButton).isDisplayed();
    }
}
