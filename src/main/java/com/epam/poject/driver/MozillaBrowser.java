package com.epam.poject.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaBrowser {

    private static WebDriver instacne;

    private MozillaBrowser() {
    }


    public static WebDriver getInstacne() {
        if (instacne==null) {
            instacne = new FirefoxDriver();
            return instacne;
        }
        return instacne;
    }

}
