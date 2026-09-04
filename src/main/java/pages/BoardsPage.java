package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage{
    public BoardsPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(
                driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//button[@data-testid='create-board-button']")
    WebElement btnCreateBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreate;
    @FindBy(xpath = "//h2[text() = 'Board deleted.']")
    WebElement popUpMsgBoardDeleted;
    @FindBy(xpath = "//*[@data-testid='header-member-menu-button']")
    WebElement btnAccount;
    @FindBy(xpath = "//span[text()='Manage account']")
    WebElement btnManageAccount;

    public boolean isButtonCreateNotClickable(){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .not(ExpectedConditions.elementToBeClickable(btnCreate)));
    }

    public void clickBtnCreateNewBoard() {
        btnCreateNewBoard.click();
    }

    public void clickBtnCreateBoard() {
        clickWait(btnCreateBoard);
    }

    public void typeBoardTitle(Board board) {
        clickWait(inputBoardTitle);
        inputBoardTitle.sendKeys(board.getTitle());
    }

    public void clickBtnCreate() {
        clickWait(btnCreate);
    }


    //to disable js  Shift+ctrl+p !!!!
    public boolean validatePopUpMessageBoardDeleted(String text){
        return isTextInElementPresent(popUpMsgBoardDeleted, text);
    }

    public void openMyAccount(){
        clickWait(btnAccount);
        clickWait(btnManageAccount);
    }
}
