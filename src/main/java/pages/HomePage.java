package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By dashboardText = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    By sortButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By HightolowButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");
    By imgTasSauceLab = By.xpath("//*[@id=\"item_4_img_link\"]/img");
    By tassauceLabText = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By imgfleeceJacket = By.xpath("//*[@id=\"item_5_img_link\"]/img");
    By fleecejacketText = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    By addtocartbackpackButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By addtocartonesiaButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
    By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    public HomePage(WebDriver driver){
        this.driver = driver;

    }
    // buat method action

    public String getcurrentURL(){
        return driver.getCurrentUrl();
    }
    public String getTittle(){
        return driver.findElement(dashboardText).getText();
    }

    public void clickSortingButton(){
         driver.findElement(sortButton).click();
    }

    public void clickHightolowButton(){
         driver.findElement(HightolowButton).click();
    }

    public void imgTasisdisplayed(){
         driver.findElement(imgTasSauceLab).isDisplayed();
    }

    public String textTasisDisplayed(){
        return driver.findElement(tassauceLabText).getText();
    }

    public void getImgfleeceJacketisDisplayed(){
        driver.findElement(imgfleeceJacket).isDisplayed();
    }

    public String getfleecejacketText(){
        return driver.findElement(fleecejacketText).getText();
    }

    public void clickaddtocartbackpackButton(){
        driver.findElement(addtocartbackpackButton).click();
    }

    public void clickaddtocartonesiaButton(){
        driver.findElement(addtocartonesiaButton).click();
    }

    public void clickcartButton(){
        driver.findElement(cartButton).click();
    }

}
