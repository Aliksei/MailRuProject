package com.epam.poject.pages;

import com.epam.poject.constants.MailConstants;
import com.epam.poject.pages.yandex_elements.AuthorizationForm;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class LoginPage extends Page {

    private AuthorizationForm authorizationForm;

    public LoginPage(WebDriver driver){
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        try {
            checkPage();
        }catch (IllegalStateException e){
            System.out.println("This is not the page you are expected");
        }
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
