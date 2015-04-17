package com.epam.poject.driver.webdriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class I_ExplorerManager extends DriverManager{

    static {
        System.setProperty("webdriver.ie.driver","C:\\Users\\Aliksei_Tkachuk\\IdeaProjects\\MailRuProject\\IEDriverServer.exe");
    }

    private  ThreadLocal<WebDriver> driver ;
    private static I_ExplorerManager instance = new I_ExplorerManager();

    private I_ExplorerManager(){}




    @Override
    public  WebDriver getDriver() {
        if(driver==null){
            driver = new ThreadLocal<WebDriver>();
        }
        driver.set(new InternetExplorerDriver());
        return driver.get();
    }

    public static I_ExplorerManager getInstance() {
        return instance;
    }
}

