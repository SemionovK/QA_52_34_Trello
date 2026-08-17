package pages;

import manager.AppManager;
import org.testng.annotations.Test;

public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest(){
        new HomePage(getDriver()).clickBtnLogin();
    }
}
