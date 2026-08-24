package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import static utils.PropertiesReader.getProperty;

public class DeleteBoardTests extends AppManager {
    BoardsPage boardsPage;
    @BeforeMethod
    public void loginAndCreateNewBoard(){
        // login
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).typeLoginForm(user);
        boardsPage = new BoardsPage(getDriver());
        // create board
        Board board = Board.builder().title("Marsik").build();
        boardsPage.clickBtnCreateNewBoard();
        boardsPage.clickBtnCreateBoard();
        boardsPage.typeBoardTitle(board);
        boardsPage.clickBtnCreate();
    }

    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(new BoardsPage(getDriver()).isUrlContainsText("boards"));
    }
}
