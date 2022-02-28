package com.example.ui6.tool;

import com.example.ui6.model.News;
import com.example.ui6.model.NewsList;
import com.example.ui6.model.Press;
import com.example.ui6.model.Rotation;
import com.example.ui6.model.Ser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetAPI {

    @GET("/prod-api/api/rotation/list")
    Call<Rotation> rot(@Query("type")String type);


    @GET("/prod-api/press/press/list")
    Call<News> news();

    @GET("/prod-api/api/service/list")
    Call<Ser> ser();

    @GET("/prod-api/press/category/list")
    Call<NewsList> newsList();

    @GET("/prod-api/press/press/list")
    Call<Press> press(@Query("type")String type);

}
