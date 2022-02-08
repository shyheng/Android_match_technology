package com.example.banner.tool;

import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Net<E> implements Callback<E> {

    public static String ip = "http://124.93.196.45:10001";

    public static Retrofit retrofit = new Retrofit.Builder().baseUrl("http://124.93.196.45:10001").addConverterFactory(GsonConverterFactory.create()).build();

    public static NetAPI net = retrofit.create(NetAPI.class);

    @Override
    public void onFailure(Call<E> call, Throwable throwable) {
        Log.e("test","网络错误");
    }
}
