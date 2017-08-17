package com.example.dd.footballGamesOnline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dd.footballGamesOnline.R;
import com.example.dd.footballGamesOnline.adapter.RecyclerViewAdapter;
import com.example.dd.footballGamesOnline.model.User;
import com.example.dd.footballGamesOnline.rest.APIClient;
import com.example.dd.footballGamesOnline.rest.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity2 extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    List<User> userList =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Log.d("123", "onCreate");
        getUserList();
    }
    private void getUserList() {
        Log.d("123", "getUserList");
        try {

            APIService service = APIClient.getClient().create(APIService.class);
            Log.d("123", " APIService service = APIClient.getClient().create(APIService.class);");

            Call<List<User>> call = service.getUserData();
            Log.d("123", "Call<List<User>> call = service.getUserData();");

            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    //Log.d("onResponse", response.message());
                    Log.d("123", "onResponse");

                    userList = response.body();
                    Log.d("123", "List<User> userList = response.body();");

                    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
                    Log.d("123", "RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);");

                    layoutManager = new LinearLayoutManager(Activity2.this);
                    Log.d("123", "layoutManager = new LinearLayoutManager(Activity2.this);");
                    recyclerView.setLayoutManager(layoutManager);
                    Log.d("123", "recyclerView.setLayoutManager(layoutManager);");

                    RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(getApplicationContext(), userList);
                    Log.d("123", "RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(getApplicationContext(), userList);");
                    recyclerView.setAdapter(recyclerViewAdapter);
                    Log.d("123", "recyclerView.setAdapter(recyclerViewAdapter);");
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d("123", t.getMessage());
                }
            });
        }catch (Exception e) {Log.d("123", "Exception");}
    }
}
