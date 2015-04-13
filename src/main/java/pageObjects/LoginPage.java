package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private static final Logger LOG = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "mailbox__login")
    private WebElement userName_area;

    @FindBy(id = "mailbox__password")
    private WebElement password_area;

    @FindBy(id = "mailbox__auth__button")
    private WebElement signiIn_button;


    public HomePage logIn(String email,String password){
        userName_area.sendKeys(email);
        password_area.sendKeys(password);
        signiIn_button.click();
        return new HomePage(driver);
    }
}
