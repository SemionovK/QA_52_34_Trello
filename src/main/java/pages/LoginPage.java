package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(
                driver, 10), this);
    }

    @FindBy(id = "username-uid1")
    WebElement inputEmail;
    @FindBy(id = "login-submit")
    WebElement btnContinue;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "login-submit")
    WebElement btnLogin;

}
