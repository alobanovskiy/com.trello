package com.trello.api;

import com.google.gson.Gson;
import com.trello.api.models.Card;
import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;
//import org.awaitility.Awaitility;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class TrelloApiTest {

    TrelloRestClient trelloRestClient;
    private TrelloApi trelloApi;
    //private List<ListOnBoard> listOnBoardList;
    private List<Card> cardList;
    private List<Board> boardsList;
    private String boardId = "5d19e8b8fef76f3783123dc3";
    private String listId = "5d190ed5d8bd8d61fbd946ea";
    private String cardId;
    private String boardForFun;
    //private List<CheckList> checklistsList;
    //private Awaitility awaitility;

        @BeforeMethod
    public void getBoardsListTest() throws IOException {
        trelloRestClient = new TrelloRestClient();
        trelloApi = new TrelloApi();
        //TrelloApiLogin.auth("lobanovsky.a.o@gmail.com", "Test1234");
    }


    @Test
    public void createBoard() throws IOException{
            Board board = new Board();
            board.name = "beautiful board";
            Gson gson = new Gson();
            boardForFun = trelloApi.createBoard(board);
        assertTrue(!boardForFun.equals(""),"board wasn't created");


    }

    @Test
    public void createList() throws IOException{
            TrelloList trelloList = new TrelloList();
            trelloList.name = "uhh";
            String newListId = trelloApi.createList(boardId, trelloList);
            System.out.println(newListId);
            listId = newListId;
    }

    @Test
    public void tcreateCard()throws IOException{
            System.out.println(listId);
            Card card = new Card();
            card.name = "final card";
            card.desc = "desc card";
            cardId = trelloApi.createCard(trelloApi.getBoardLists(boardId).get(0).id, card);
    }

    @AfterTest
    public void dropAll() throws IOException, InterruptedException{
            Thread.sleep(55000);
            trelloRestClient.boardsService.deleteBoard(boardForFun).execute();
            System.out.println(trelloRestClient.cardsService.deleteCard(cardId).execute().code());
            trelloRestClient.listsService.deleteList("5d1a044f824cf44624c5b68f").execute();

    }

}