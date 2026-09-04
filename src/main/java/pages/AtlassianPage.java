package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianPage extends BasePage{
    public AtlassianPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(
                driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid='profile-avatar-dropdown-trigger']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeProfilePhoto;
    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputPhoto;
    @FindBy(xpath = "//button[@class='css-vm8vhv' and @type='submit']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='_19itglyw _vchhusvi _r06hglyw _1q511b66 _85i5v77o _1i4qfg65']")
    WebElement popUpMessage;
    @FindBy(xpath = "//div[@class='ellipsed-text css-0']")
    WebElement popUpWrongFormat;


    public void changeProfilePhoto(String photoPath){
        //clickWait(btnProfilePhoto); doesnt'work
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).click().perform(); // we will move to the center
        clickWait(btnChangeProfilePhoto);
        File photo = new File(photoPath);
        inputPhoto.sendKeys(photo.getAbsolutePath());
    }

    public void clickBtnUpload(){
        //clickWait(btnUpload);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnUpload).click().perform();
    }

    public boolean validatePopUpMessage(String text){
        return isTextInElementPresent(popUpMessage, text);
    }

    public boolean validatePopUpWrongFormat(String text){
        return isTextInElementPresent(popUpWrongFormat, text);
    }


}
