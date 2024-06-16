import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void Checkout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CartStepOnePage cartOne = new CartStepOnePage(driver);
        CartStepTwoPage cartTwo = new CartStepTwoPage(driver);
        CartCompletePage cartComplete = new CartCompletePage(driver);

        //wait 15 detik saat input username
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.clickaddtocartbackpackButton();
        homePage.clickaddtocartonesiaButton();
        homePage.clickcartButton();

        cartPage.clickcheckoutButton();

        cartOne.inputFirstname("Kobra");
        cartOne.inputLastname("Hitam");
        cartOne.inputZipcode("272727");
        cartOne.clickcontinueButton();

        cartTwo.clickfinishButton();

        //assertion1 get current url
        Assert.assertEquals(cartComplete.getcurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");

        //assertion2 get tittle
        Assert.assertEquals(cartComplete.getTittle(),"Swag Labs");

        //assertion3 Tick img is displayed
        cartComplete.imgtickisDisplayed();

        //assertion4 assert complete order text
        Assert.assertEquals(cartComplete.getcompleteorderText(),"Thank you for your order!");

        //assertion5 assert conmplete text detail
        Assert.assertEquals(cartComplete.getcompleteText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
