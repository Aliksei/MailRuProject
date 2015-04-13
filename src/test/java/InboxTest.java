import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class InboxTest {

    private static Logger LOG = Logger.getLogger(InboxTest.class);

    private WebDriver driver;
    private HomePage homePage;


    @BeforeTest
    public void init(){
        driver=MozillaBrowser.getInstacne();
        homePage=new HomePage(driver);
    }

    @Test
    public void isUserLogged_Test(){
        LOG.info("isUserLogged_Test is running");
        Assert.assertTrue(DriverUtils.isElementExists(homePage.getUSER_NAME_BUTTON()), "Login has finished successfully");
    }

    @Test(dependsOnMethods = "isUserLogged_Test")
    public void isMessageExistTest_Test(){
        LOG.info("isMessageExistTest_Test is running");
        Assert.assertTrue(DriverUtils.isElementExists(homePage.getMESSAGES_BY()), "Message exists");
    }

    @AfterSuite()
    public void tearDown(){
        driver.quit();
    }
}
