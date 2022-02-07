package com.example.network;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.network.entity.User;
import com.example.network.tool.Net;
import com.example.network.tool.NetAPI;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;
import static com.example.network.tool.Net.token;

public class APP extends Application {
    @Override
    public void onCreate() {

        SharedPreferences shared = getSharedPreferences("token",MODE_PRIVATE);
        final SharedPreferences.Editor edit = shared.edit();
        netAPI.token(new NetAPI.Users("shyheng", "123456")).enqueue(new Net<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                token = response.body().getToken();
                System.out.println(token);
                edit.putString("token",token);
                edit.commit();
            }
        });
        super.onCreate();
    }
}
