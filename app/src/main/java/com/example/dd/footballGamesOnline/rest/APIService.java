package com.example.dd.footballGamesOnline.rest;

import com.example.dd.footballGamesOnline.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dd on 03.05.2017.
 */

public interface APIService {
    @GET("v1/competitions")

    Call<List<User>> getUserData();


}
