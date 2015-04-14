package com.epam.poject.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriverUtils {

    public static boolean isElementExists(By locator){
        return MozillaBrowser.getInstacne().findElements(locator).size()>0;
    }

    public static boolean isElementExists(WebElement element){
            if(element.isDisplayed() && element.isEnabled()){
                return true;
            }
            return false;
    }
}
