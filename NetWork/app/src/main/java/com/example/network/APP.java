package com.example.network;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.network.entity.Obj;
import com.example.network.tool.Net;
import com.example.network.tool.NetAPI;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;

public class APP extends Application {
    @Override
    public void onCreate() {

        SharedPreferences shared = getSharedPreferences("token",MODE_PRIVATE);
        final SharedPreferences.Editor edit = shared.edit();
        netAPI.token(new Obj.Users("shyheng", "123456")).enqueue(new Net<Obj.Token>() {
            @Override
            public void onResponse(Call<Obj.Token> call, Response<Obj.Token> response) {
                token = response.body().token;
                System.out.println(token);
                edit.putString("token",token);
                edit.commit();
            }
        });

        super.onCreate();
    }
}
