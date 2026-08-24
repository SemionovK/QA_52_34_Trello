package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBoardPage extends BasePage{
    public MyBoardPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(
                driver, 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;
    @FindBy(xpath = "//button[@aria-label='Show menu']")
    WebElement btnDots;
    //private By btnDots = By.xpath("//button[@aria-label='Show menu']");
    @FindBy(xpath = "//div[text()='Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnPermDeleteBoard;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDeleteConfirm;

    public boolean validateBoardName(String text){
        return isTextInElementPresent(boardName, text);
    }

    public void deleteBoard() {
        clickWait(btnDots);
        clickWait(btnCloseBoard);
        clickWait(btnClose);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(btnClose));
        clickWait(btnDots);
        clickWait(btnPermDeleteBoard);
        clickWait(btnDeleteConfirm);
    }
}
