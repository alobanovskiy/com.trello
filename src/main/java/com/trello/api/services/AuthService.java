package com.trello.api.services;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class AuthService {

    public static void auth(String user, String password){

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("method", "password")
                .addFormDataPart("factors[user]", user)
                .addFormDataPart("factors[password]",password)
                .addFormDataPart("castleClientId","5b74203e-86be-456f-9266-f82f56439782-4b33e44907a9c679958fe803")
                .build();
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/authentication").post(requestBody)
                .build();
        String response =request.toString();
        System.out.println(response);
    }
}
