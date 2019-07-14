package com.trello.api.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;

import java.util.List;

public interface ListsService {
    //https://api.trello.com/1/lists/id
    @GET("lists/{id}")
    Call<List<TrelloList>> getLists(@Path("id")String id);


    @POST("lists")
    Call<Board> createList(@Query("name") String name);

    @DELETE("lists/{id}")
    Call<ResponseBody> deleteList(@Path("id")String id);

    @PUT("lists/{id}")
    Call<Board> updateList(@Path("id")String id, @Body Board board);

}
