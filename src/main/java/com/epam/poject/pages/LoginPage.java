package com.epam.poject.pages;

import com.epam.poject.constants.MailConstants;
import com.epam.poject.pages.blocks.AuthorizationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class LoginPage extends Page {

    protected AuthorizationForm authorizationForm;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    @Override
    public void checkPage() {
        if (!driver.getCurrentUrl().contains(MailConstants.URL)) {
            throw new IllegalStateException();
        }
    }

    public HomePage logIn(String email,String password){
        authorizationForm.login(email,password);
        return new HomePage(driver);
    }
}
