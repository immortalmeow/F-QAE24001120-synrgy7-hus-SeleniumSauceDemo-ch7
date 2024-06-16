import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SortingTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void sortingTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //wait 15 detik saat input username
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.clickSortingButton();
        homePage.clickHightolowButton();

        //assertion1 validate current url
        Assert.assertEquals(homePage.getcurrentURL(),"https://www.saucedemo.com/inventory.html");

        //assertion2 validate tittle
        Assert.assertEquals(homePage.getTittle(),"Swag Labs");

        //assertion3 validate img fleece jacket
        homePage.getImgfleeceJacketisDisplayed();

        //assertion4 validate text fleece jacket
        Assert.assertEquals(homePage.getfleecejacketText(),"Sauce Labs Fleece Jacket");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
