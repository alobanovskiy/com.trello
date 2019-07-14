package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by lolik on 20.06.2019
 */
public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    BoardPage boardPage = new BoardPage();

    @Test
    public void login() throws InterruptedException {
        loginPage.open();
        loginPage.login("lobanovsky.a.o@gmail.com", "Test1234");
        boardsPage.openBoard("test-board");
        boardPage.deleteBoard();
        //assertTrue(boardPage.isPrivate());
    }

}
