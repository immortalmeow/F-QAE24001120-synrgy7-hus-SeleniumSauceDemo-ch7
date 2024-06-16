package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartCompletePage {
    WebDriver driver;

    By imgTick =By.xpath("//*[@id=\"checkout_complete_container\"]/img");
    By completeorderText = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    By completeText = By.xpath("//*[@id=\"checkout_complete_container\"]/div");
    By carttittleText = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    public CartCompletePage(WebDriver driver){
        this.driver = driver;
    }

    //Buat methode untuk action
    public String getcurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getTittle(){
        return driver.findElement(carttittleText).getText();
    }
    public void imgtickisDisplayed(){
        driver.findElement(imgTick).isDisplayed();
    }
    public String getcompleteorderText(){
        return driver.findElement(completeorderText).getText();
    }
    public String getcompleteText(){
        return driver.findElement(completeText).getText();
    }
}
