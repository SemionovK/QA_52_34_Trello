package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AtlassianPage extends BasePage{
    public AtlassianPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(
                driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid='profile-avatar-dropdown-trigger']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeProfilePhoto;


    public void changeProfilePhoto(){
        //clickWait(btnProfilePhoto); doesnt'work
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).click().perform(); // we will move to the center
        clickWait(btnChangeProfilePhoto);
    }


}
