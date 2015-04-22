package com.epam.poject.driver.webdriverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager extends DriverManager {

    static {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    }


    private  ThreadLocal<WebDriver> driver ;
    private static ChromeManager instance = new ChromeManager();

    private ChromeManager(){}

    @Override
    public  WebDriver getDriver() {
        if(driver==null){
            driver = new ThreadLocal<WebDriver>();
        }
            driver.set(new ChromeDriver());
        return driver.get();
    }

    public static ChromeManager getInstance() {
        return instance;
    }
}
