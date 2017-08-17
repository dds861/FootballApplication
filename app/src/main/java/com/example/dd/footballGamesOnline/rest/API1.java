package com.example.dd.footballGamesOnline.rest;

import com.example.dd.footballGamesOnline.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dd on 15.08.2017.
 */

public interface API1 {
    @GET("v1/competitions/444/teams")
    Call<List<User>> getUserData();
}
