package com.example.network.tool;

import com.example.network.entity.News;
import com.example.network.entity.NewsList;
import com.example.network.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetAPI {

    @GET("/prod-api/press/press/list")
    Call<News> test(@Query("type")Integer type);

    @GET("/prod-api/press/category/list")
    Call<NewsList> list();


    class Users{
        public Users(String username, String password) {
            this.username = username;
            this.password = password;
        }

        String username;
        String password;
    }
    @POST("/prod-api/api/login")
    Call<User> token(@Body Users users);


    class Msg{
        String msg;
        String code;

        public String getMsg() {
            return msg;
        }

        public String getCode() {
            return code;
        }
    }

    @POST("/prod-api/api/common/balance/recharge")
    Call<Msg> money(@Header("Authorization")String token, @Query("money") Integer money);



}
