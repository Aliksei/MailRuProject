package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    private  final By MESSAGES_BY = By.xpath("//div[@class='b-datalist__item__addr']");
    private  final By USER_NAME_BUTTON = By.id("PH_user-email");


    public  By getUSER_NAME_BUTTON() {
        return USER_NAME_BUTTON;
    }
    public  By getMESSAGES_BY() {
        return MESSAGES_BY;
    }


    public String chekMessage(){
        return driver.findElement(MESSAGES_BY).getText();
    }
}
