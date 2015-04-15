package com.epam.poject.driver.webdriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends DriverManager {

    private WebDriver instance;

    @Override
    public synchronized WebDriver  getDriver() {
        if(instance==null){
            instance = new FirefoxDriver();
        }
        return instance;
    }
}
