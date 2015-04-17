package com.epam.poject.utils;

import org.openqa.selenium.WebElement;

public class DriverUtils {


    public static boolean isElementExists(WebElement element){
        return element.isDisplayed() && element.isEnabled();
    }
}
