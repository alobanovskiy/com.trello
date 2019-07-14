package com.trello.ui.pages;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Elem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by lolik on 20.06.2019
 */
public class BoardPage extends BrowserFactory{

    private Elem moreButton = new Elem(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
    private Elem closeBoardButton = new Elem(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    private Elem confirmClose = new Elem(By.cssSelector(".js-confirm.full.negate"));
    private Elem fullClose = new Elem(By.cssSelector(".quiet.js-delete"));
    private int id = 1;
    private Elem listOnTheBoard = new Elem(By.xpath("//*[@id='board']/div["+ id +"]/div"));
    private Elem addCardButton = new Elem(By.xpath("//*[@id='board']/div["+ id +"]/div/a/span[2]"));
    private Elem addCardTitle = new Elem(By.cssSelector(".js-card-title"));
    private Elem addListButton = new Elem(By.cssSelector(".js-open-add-list"));//list-name-input
    private Elem addListTitle = new Elem(By.cssSelector(".list-name-input"));//
    private Elem addListConfirm = new Elem(By.cssSelector(".js-save-edit"));
    private Elem addCardConfirm = new Elem(By.cssSelector(".js-add-card"));
    private Elem cardOnTheBoard = new Elem(By.cssSelector(".js-card-name"));
    private Elem accessSelector = new Elem(By.cssSelector(".board-header-btn.perms-btn.js-change-vis"));
    private Elem cardDescrition = new Elem(By.cssSelector(".card-description"));
    private Elem changeCardMembers = new Elem(By.cssSelector(".js-change-card-members"));
    private Elem selectMember = new Elem(By.cssSelector(".js-select-member"));
    private Elem editLabels = new Elem(By.cssSelector(".js-edit-labels"));
    private Elem addLabel = new Elem(By.cssSelector(".js-select-label"));


    @Step
    public void addList(String title){
        addListButton.click();
        addListTitle.type(title);
        addListConfirm.click();
    };

    @Step
    public boolean isPrivate(){
        String access = accessSelector.getText();
        if (access.equals("Приватная"))
            return true;
        else
            return false;
    };

    @Step
    public void deleteBoard() {
        String expContent = "Доска не найдена.";
        moreButton.click();
        closeBoardButton.click();
        confirmClose.click();
        fullClose.click();
        confirmClose.click();
        (new WebDriverWait(driver(),12))
              .until(ExpectedConditions.textToBe(By.cssSelector(".big-message.quiet > h1"),expContent));
    }

    @Step
    public void editCard(String desc){
        cardOnTheBoard.click();
        cardDescrition.click();
        cardDescrition.type(desc);
        driver().findElements(By.cssSelector(".js-save-edit")).get(1).click();
        changeCardMembers.click();
        selectMember.click();
        driver().findElements(By.cssSelector(".icon-close")).get(5).click();
        editLabels.click();
        addLabel.click();

    };

    @Step
    public void addAnotherCard(String title){
        addCardButton.click();
        addCardTitle.type(title);
        addCardConfirm.click();
    }

}
