package com.trello.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.trello.api.models.Board;
import okhttp3.*;
import com.trello.api.models.TrelloList;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import com.trello.api.models.Card;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    Gson gson = new Gson();

    public static final String KEY = "5b28a6d145e62bb07cfd0bf0bbf6a83e";
    public static final String TOKEN = "f6badf2323801ffc98c607404d54c730da68b94a70ad14fab7d4da3688d1a80d";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();


    public String createBoard(Board board) throws IOException {
        String json = gson.toJson(board);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards?cards=all&fields=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        String id = jsonObject.get("id").toString();
        return id;
    }

    public List<TrelloList> getBoardLists(String boardId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/"+boardId+"/lists?cards=all&fields=all&key="+KEY+"&token="+TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloList>>(){}.getType();
        List<TrelloList> trelloLists = gson.fromJson(response, type);
        return trelloLists;
    }

    public String createCard(String listId, Card card) throws IOException {
        String json = gson.toJson(card);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        String id = jsonObject.get("id").toString();
        System.out.println(id);
        return id;
    }

    public String createList(String idBoard, TrelloList list) throws IOException {
        String json = gson.toJson(list);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists?idBoard="+idBoard+"&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        String id = jsonObject.get("id").toString();
        return id;
    }



    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
