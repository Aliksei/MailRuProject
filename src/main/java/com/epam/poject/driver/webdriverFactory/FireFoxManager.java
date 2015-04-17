package com.epam.poject.driver.webdriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends DriverManager {


    private  ThreadLocal<WebDriver> driver ;
    private static FireFoxManager instance = new FireFoxManager();


    private FireFoxManager(){}


    @Override
    public  WebDriver getDriver() {
        if(driver==null){
            driver = new ThreadLocal<WebDriver>();
        }
        driver.set(new FirefoxDriver());
        return driver.get();
    }

    public static FireFoxManager getInstance() {
        return instance;
    }
}
