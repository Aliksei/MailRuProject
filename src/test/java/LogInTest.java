import constants.MailConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LogInTest {

    private static Logger LOG = Logger.getLogger(LogInTest.class);
    private WebDriver driver;
    private HomePage homePage;

    @DataProvider(name = "loginInfo")
    public Object[][] setLoginInfo(){
        return new Object[][] {{"testautomationepam","epam8433"}};
    }

    @BeforeTest
    public  void connectToUrl(){
        driver=MozillaBrowser.getInstacne();
        driver.get(MailConstants.getUrl());
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "loginInfo")
    public void loginTest(String email,String password){
        LOG.info("logging test is running");
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.logIn(email,password);
        Assert.assertTrue(driver.getCurrentUrl().equals(MailConstants.getHomePageUrl()));
    }
}
