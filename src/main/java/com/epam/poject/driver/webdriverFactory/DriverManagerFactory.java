package com.epam.poject.driver.webdriverFactory;

import com.epam.poject.pages.LoginPage;
import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManagerFactory  extends AbstractModule{


    private static DriverEnum type ;
    private static FireFoxManager fireFoxManager = new FireFoxManager();
    private static ChromeManager chromeManager = new ChromeManager();
    private static Properties properties;
    private WebDriver wd;
    private LoginPage loginPage;


    static {
        try{
            properties = new Properties();
            properties.setProperty("driver_type", "mozilla");
            properties.load(new FileInputStream("C:\\Users\\Aliksei_Tkachuk\\IdeaProjects\\MailRuProject\\src\\main\\resources\\driver_type.properties"));
            type = DriverEnum.defineEnumType(properties.getProperty("driver_type"));
        }catch (IOException e) {}

    }


    public static DriverManager getRequiredDriver(){
        switch (type){
            case CHROME:
                return chromeManager  ;
            case FIREFOX:
                return fireFoxManager ;
        }
        return null;
    }

    @Override
    protected void configure() {
        DriverManager driverManager =getRequiredDriver();
        wd = driverManager.getDriver();
        loginPage=new LoginPage(wd);
        bind(WebDriver.class).toInstance(wd);
        bind(LoginPage.class).toInstance(loginPage);
    }
}
