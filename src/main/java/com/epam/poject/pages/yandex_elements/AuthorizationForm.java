package com.epam.poject.pages.yandex_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Block(@FindBy(className = "mailbox"))
public class AuthorizationForm extends HtmlElement {

    @FindBy(id = "mailbox__login")
    private WebElement loginField;

    @FindBy(id = "mailbox__password")
    private WebElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement submitButton;

    public void login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
