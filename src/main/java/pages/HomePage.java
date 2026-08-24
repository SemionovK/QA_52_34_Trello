package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://trello.com/");
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);

    }

    @FindBy(xpath = "//a[@href='https://id.atlassian.com/login?application=trello--direct-signup&continue=https%3A%2F%2Ftrello.com%2Fauth%2Fatlassian%2Fcallback&anonId=4a18e1ce-fe03-4037-8774-aab78a4b5a27']")
    WebElement btnLogin;

    public void clickBtnLogin(){
        btnLogin.click();
    }
}
