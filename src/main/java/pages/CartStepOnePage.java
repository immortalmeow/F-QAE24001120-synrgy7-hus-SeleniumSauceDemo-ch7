package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartStepOnePage {
    WebDriver driver;

    By firstnameField = By.xpath("//*[@id=\"first-name\"]");
    By lastnameField = By.xpath("//*[@id=\"last-name\"]");
    By zipcodeField = By.xpath("//*[@id=\"postal-code\"]");
    By continueButton = By.xpath("//*[@id=\"continue\"]");

    public CartStepOnePage(WebDriver driver){
        this.driver = driver;
    }

    //buat methode untuk action
    public void inputFirstname(String firstName){
        driver.findElement(firstnameField).sendKeys(firstName);
    }
    public void inputLastname(String lastName){
        driver.findElement(lastnameField).sendKeys(lastName);
    }
    public void inputZipcode(String zipcode){
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }
    public void clickcontinueButton(){
        driver.findElement(continueButton).click();
    }
}
