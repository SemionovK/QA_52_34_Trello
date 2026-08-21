package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.PropertiesReader.*;

import static utils.PropertiesReader.getProperty;

public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).typeLoginForm(user);
        Assert.assertTrue(new BoardsPage(getDriver()).isUrlContainsText("boards"));
    }
}
