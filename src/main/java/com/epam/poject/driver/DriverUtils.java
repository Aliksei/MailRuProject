package com.epam.poject.driver;

import org.openqa.selenium.WebElement;

public class DriverUtils {


    public static boolean isElementExists(WebElement element){
            if(element.isDisplayed() && element.isEnabled()){
                return true;
            }
            return false;
    }
}
