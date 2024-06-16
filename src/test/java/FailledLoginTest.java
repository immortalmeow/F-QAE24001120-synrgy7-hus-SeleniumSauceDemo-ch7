import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FailledLoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void FailedLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //wait 15 detik saat input username
        loginPage.inputUsername("standard_user");

        //input wrong password
        loginPage.inputPassword("saus_rahasia");
        loginPage.clickLoginButton();

        //assertion1 get current url
        Assert.assertEquals(loginPage.getcurrentURL(),"https://www.saucedemo.com/");

        //assertion2 get logintext tittle
        Assert.assertEquals(loginPage.getTittle(),"Swag Labs");

        //assertion 3 get error text
        Assert.assertEquals(loginPage.getErrorText(),"Epic sadface: Username and password do not match any user in this service");

        //assertion 4 get cross button password is displayed
        loginPage.passwordcrossButtonIsDisplayed();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
