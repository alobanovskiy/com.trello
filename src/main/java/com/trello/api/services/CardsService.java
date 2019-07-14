package com.trello.api.services;

import com.trello.api.models.Board;
import com.trello.api.models.Card;
import com.trello.api.models.TrelloList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CardsService {
    //https://api.trello.com/1/cards/id
    @GET("lists/{id}/cards")
    Call<List<Card>> getCards(@Path("id") String id);

    @GET("cards/{id}")
    Call<Card> getCard(@Path("id") String id);

    @POST("cards")
    Call<Card> createCard(@Query("name") String name, @Query("idList") String idList);

    @PUT("cards/{id}")
    Call<Card> updateCard(@Path("id") String id, @Body Card card);

    @DELETE("cards/{id}")
    Call<ResponseBody> deleteCard(@Path("id") String id);

    //@GET("cards/{id}/members")
    //Call<List<Members>> getMembersList(@Path("id") String id);
}
