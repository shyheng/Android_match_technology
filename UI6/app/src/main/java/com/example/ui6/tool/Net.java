package com.example.ui6.tool;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Net<E> implements Callback<E> {

    public static String ip = "http://124.93.196.45:10001/";

    static Retrofit retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();

    public static NetAPI netAPI = retrofit.create(NetAPI.class);

    @Override
    public void onFailure(Call<E> call, Throwable throwable) {
        Log.e("shy","网络出错");
    }
}
