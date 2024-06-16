package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    // buat methode untuk action

    public void clickcheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

}


