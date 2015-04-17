package com.epam.poject.driver.webdriverFactory;

import com.epam.poject.exceptions.DriverEnumException;
import com.epam.poject.pages.LoginPage;
import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManagerFactory  extends AbstractModule{


    private static DriverEnum type ;
    private static DriverManager fireFoxManager =FireFoxManager.getInstance();
    private static DriverManager chromeManager = ChromeManager.getInstance();
    private static DriverManager i_explorerManager = I_ExplorerManager.getInstance();

    static {
            Properties properties = new Properties();
            properties.setProperty("driver_type", "mozilla");
        try {
            properties.load(new FileInputStream("C:\\Users\\Aliksei_Tkachuk\\IdeaProjects\\MailRuProject\\src\\main\\resources\\driver_type.properties"));
             type = DriverEnum.defineEnumType(properties.getProperty("driver_type"));
        } catch (DriverEnumException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static DriverManager getRequiredManager(){
        switch (type){
            case CHROME:
                return chromeManager  ;
            case FIREFOX:
                return fireFoxManager ;
            case I_EXPLORER:
                return i_explorerManager;
        }
        return fireFoxManager;
    }


    @Override
    protected void configure() {
        DriverManager driverManager = getRequiredManager();
        WebDriver wd = driverManager.getDriver();
        LoginPage loginPage = new LoginPage(wd);
        bind(WebDriver.class).toInstance(wd);
        bind(LoginPage.class).toInstance(loginPage);
    }
}
