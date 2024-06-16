package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartStepTwoPage {
    WebDriver driver;

    By finishButton = By.xpath("//*[@id=\"finish\"]");

    public CartStepTwoPage(WebDriver driver){
        this.driver = driver;
    }
    // buat methode untuk action
    public void clickfinishButton(){
        driver.findElement(finishButton).click();
    }

}
