package com.epam.poject.tests;

import com.epam.poject.driver.webdriverFactory.DriverManagerFactory;
import com.epam.poject.constants.MailConstants;
import com.epam.poject.utils.DriverUtils;
import com.epam.poject.pages.HomePage;
import com.epam.poject.pages.LoginPage;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MailRuTest {


    private static Logger LOG = Logger.getLogger(MailRuTest.class);
    private HomePage homePage;

    @Inject
    protected   WebDriver  driver;
    @Inject
    protected LoginPage loginPage;

    @BeforeSuite
    public void inint(){
        LOG.info("Injecting elements");
        Injector injector= com.google.inject.Guice.createInjector(new DriverManagerFactory());
        injector.injectMembers(this);
    }

    @DataProvider(name = "loginInfo")
    public Object[][] setLoginInfo(){
        return new Object[][] {{"testautomationepam","epam8433"}};
    }

    @BeforeTest
    public  void connectToUrl() {
        LOG.info("connecting to URL");
        driver.get(MailConstants.URL);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginInfo")
    public void tryToLogInTest(String email,String password){
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
        LOG.info("Closing the browser");
        driver.quit();
    }


}
