package com.trello.ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.trello.ui.core.BrowserFactory.driver;
import static com.trello.ui.core.BrowserFactory.getWebDriverWait;


/**
 * Created by lolik on 20.06.2019
 */
public class Elem {

    private By by;
    private String name;

    public Elem(By by,String name){
        this.by = by;
        this.name = name;
    }

    public Elem(By by){
        this(by, "");
    }

    public String getText(){
        return find().getText();
    };

    public WebElement find(){
        return getWebDriverWait(20).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(){
        find().click();
    }

    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    private void hover(WebElement element){
        Actions builder = new Actions(driver());
        builder.moveToElement(element).perform();
    };

    public boolean isPresent(){
        try {
            getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }


}
