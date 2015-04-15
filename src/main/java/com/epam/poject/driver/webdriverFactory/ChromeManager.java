package com.epam.poject.driver.webdriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager extends DriverManager {

    private static WebDriver instance ;

    static {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Aliksei_Tkachuk\\Downloads\\chromedriver.exe");
    }

    @Override
    public synchronized  WebDriver getDriver() {
        if(instance==null){
            instance = new ChromeDriver();
        }
        return instance;
    }
}
