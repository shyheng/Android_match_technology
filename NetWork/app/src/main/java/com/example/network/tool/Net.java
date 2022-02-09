package com.example.network.tool;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Net<E> implements Callback<E> {

    public static String token;
    public static String url = "http://124.93.196.45:10001";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static NetAPI netAPI = retrofit.create(NetAPI.class);

    @Override
    public void onFailure(Call<E> call, Throwable throwable) {
        throwable.printStackTrace();
        Log.e("net","网络错误");
    }


}
