package com.epam.poject.driver;

import com.epam.poject.pages.LoginPage;
import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

public class DriverthrouhgTheGuice extends AbstractModule{

    private WebDriver wd;
    private LoginPage loginPage;

    @Override
    protected void configure() {
        wd = MozillaBrowser.getInstacne();
        loginPage=new LoginPage(wd);
        bind(WebDriver.class).toInstance(wd);
        bind(LoginPage.class).toInstance(loginPage);

    }
}
