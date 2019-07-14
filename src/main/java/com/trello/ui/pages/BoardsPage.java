package com.trello.ui.pages;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Elem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lolik on 20.06.2019
 */
public class BoardsPage extends BrowserFactory{

    private Elem profileButton = new Elem(By.cssSelector(".member-initials"));
    private Elem settingsMenuButton = new Elem(By.cssSelector("a.js-profile"));
    private Elem logoutMenuButton = new Elem(By.cssSelector("a.js-logout"));
    private Elem createBoard = new Elem(By.cssSelector(".board-tile.mod-add"));
    private Elem boardTitle = new Elem(By.cssSelector(".subtle-input"));
    private Elem createBoardButton = new Elem(By.cssSelector(".primary"));
    private Elem favorite = new Elem(By.cssSelector(".board-tile-options"));
    private Elem boardClipBoard = new Elem(By.cssSelector("li.boards-page-board-section-list-item"));
    private Elem boardList = new Elem(By.cssSelector(".boards-page-board-section.mod-no-sidebar"));
    private Elem boardListHeader = new Elem(By.cssSelector(".boards-page-board-section-header-name"));

    private static final String PATH = "loliktest4/boards";


    @Step
    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }

    public void logOut(){
        profileButton.click();
        logoutMenuButton.click();
    };

    @Step
    public void createBoard(String boardName){
        createBoard.click();
        boardTitle.type(boardName);
        createBoardButton.click();
        String wordInUrl = boardName.replaceAll(" ", "-").toLowerCase();
        (new WebDriverWait(driver(),8))
                .until(ExpectedConditions.urlContains(wordInUrl));
    }


    @Step
    public void open(){

    }

    @Step
    public void isOpened(){

    }

    @Step
    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }


}
