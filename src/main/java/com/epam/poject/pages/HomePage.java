package com.epam.poject.pages;

import com.epam.poject.constants.MailConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        try {
            checkPage();
        }catch (IllegalStateException e){
            System.out.println("This is not the page you are expected");
        }
    }

    @Override
    public void checkPage() {
        if (!driver.getCurrentUrl().contains(MailConstants.HOME_PAGE_URL)) {
            throw new IllegalStateException();
        }
    }

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@class='b-datalist__item__addr']")
    private WebElement messages;

    @FindBy(id = "PH_user-email")
    private WebElement userNameframe;


    public WebElement getUserNameframe() {
        return userNameframe;
    }
    public WebElement getMessages() {
        return messages;
    }
}
