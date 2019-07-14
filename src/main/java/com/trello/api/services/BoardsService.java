package com.trello.api.services;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import com.trello.api.models.Board;
import com.trello.api.models.TrelloList;

import java.util.List;

/**
 * Created by lolik on 13.06.2019
 */
public interface
BoardsService {


    @POST("authentication")
    Call<ResponseBody> getAuthentificationResponse(@Body RequestBody body);

    //@GET("members/{id}/tokens")
    //Call<List<Token>> getUserTokenList(@Path("id") String id);

    @GET("members/{id}/boards")
    Call<List<Board>> getMembersBoards(@Path("id") String id);

    @POST("boards")
    Call<Board> createBoard(@Query("name") String name);

    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id") String id);

    @PUT("boards/{id}")
    Call<Board> updateBoard(@Path("id") String id, @Body Board board);



}
