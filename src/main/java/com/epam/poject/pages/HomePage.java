package com.epam.poject.pages;

import com.epam.poject.constants.MailConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page {

    @FindBy(xpath = "//div[@class='b-datalist__item__addr']")
    private WebElement messages;

    @FindBy(id = "PH_user-email")
    private WebElement userNameframe;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void checkPage() {
        if (!driver.getCurrentUrl().contains(MailConstants.HOME_PAGE_URL)) {
            throw new IllegalStateException();
        }
    }

    public WebElement getUserNameframe() {
        return userNameframe;
    }
    public WebElement getMessages() {
        return messages;
    }
}
