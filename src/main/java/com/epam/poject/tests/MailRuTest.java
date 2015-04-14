package com.epam.poject.tests;

import com.epam.poject.constants.MailConstants;
import com.epam.poject.driver.DriverUtils;
import com.epam.poject.driver.MozillaBrowser;
import com.epam.poject.pages.HomePage;
import com.epam.poject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MailRuTest {

    private WebDriver driver;
    private HomePage homePage;


    @BeforeSuite
    public void inint(){
        driver = MozillaBrowser.getInstacne();
    }

    @DataProvider(name = "loginInfo")
    public Object[][] setLoginInfo(){
        return new Object[][] {{"testautomationepam","epam8433"}};
    }


    @BeforeTest
    public  void connectToUrl() {
        driver.get(MailConstants.URL);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginInfo")
    public void tryToLogInTest(String email,String password){
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.logIn(email, password);
        Assert.assertTrue(driver.getCurrentUrl().equals(MailConstants.HOME_PAGE_URL));
    }

    @Test(dependsOnMethods = "tryToLogInTest")
    public void isUserLoggedTest(){
        Assert.assertTrue(DriverUtils.isElementExists(homePage.getUserNameframe()), "Login failed");
    }


    @Test(dependsOnMethods = "isUserLoggedTest")
    public void isMessageExistTest(){
        Assert.assertTrue(DriverUtils.isElementExists(homePage.getMessages()), "Message doesnt exist");
    }

    @AfterSuite()
    public void tearDown(){
        driver.quit();
    }
}
