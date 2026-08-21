package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.PropertiesReader.getProperty;

public class BoardsTest extends AppManager {
    BoardsPage boardsPage;
    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).typeLoginForm(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().title("Marsik").build();
        boardsPage.clickBtnCreateNewBoard();
        boardsPage.clickBtnCreateBoard();
        boardsPage.typeBoardTitle(board);
        boardsPage.clickBtnCreate();
    }
}
