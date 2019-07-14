package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Elem;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class CreateAndDeleteBoardTest extends BrowserFactory{
    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    BoardPage boardPage = new BoardPage();
    String boardToDelete;
    Elem finalMessageAfterDelete = new Elem(By.cssSelector(".big-message.quiet > h1"));


    @BeforeMethod
    public void setMethod(){
        loginPage.open();
        loginPage.login("lobanovsky.a.o@gmail.com", "Test1234");

    }

    @Test
    void createBoardTest(){
        System.out.println(driver().getCurrentUrl());
        boardsPage.createBoard("cool board");
        assertTrue(boardPage.isPrivate(),"board has incorrect access permissions");
        boardToDelete = driver().getCurrentUrl();

    }

    @Test(dependsOnMethods = { "createBoardTest" })
    void deleteBoard()throws InterruptedException{
        (new WebDriverWait(driver(),4))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".boards-page-board-section-list-item")));
        driver().get(boardToDelete);
        boardPage.addList("title");
        sleep(5000);
        boardPage.addAnotherCard("card title");
        boardPage.editCard("test");
        driver().getCurrentUrl();
        boardPage.deleteBoard();

    }
}
