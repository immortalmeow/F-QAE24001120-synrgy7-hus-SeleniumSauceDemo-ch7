import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void LoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //wait 15 detik saat input username
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //assertion1 validate url
        Assert.assertEquals(homePage.getcurrentURL(),"https://www.saucedemo.com/inventory.html");
        //assertion2 validate tittle
        Assert.assertEquals(homePage.getTittle(),"Swag Labs");
        //assertion3 validate img Tas Sauce Labs
        homePage.imgTasisdisplayed();
        //assertion 4 validate text Tas Sauce Labs
        Assert.assertEquals(homePage.textTasisDisplayed(),"Sauce Labs Backpack");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
