package com.example.banner.tool;

import com.example.banner.model.ZY;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetAPI {

    @GET("/prod-api/api/rotation/list")
    Call<ZY> zy();
}
