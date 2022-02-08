package com.example.network.tool;

import com.example.network.entity.News;
import com.example.network.entity.NewsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface NetAPI {

    class Users {
        public Users(String username, String password) {
            this.username = username;
            this.password = password;
        }
        String username;
        String password;
    }
    class Token {
        public String token;
    }
    //    用户登录
    @POST("/prod-api/api/login")
    Call<Token> token(@Body Users users);

    class User{
        public String userName;
        public String password;
        public String phonenumber;
        public String sex;
        public String idCard;
        public String nickName;
    }
//    用户注册
    @POST("/prod-api/api/register")
    Call<Msg> reg(@Body User user);

    class UserInfo{
        public List<E> user;
        class E{
            public String userName;
            public String email;
            public String phonenumber;
            public String sex;
            public String idCard;
        }
    }
//    查看用户信息
    @GET("/prod-api/api/common/user/getInfo")
    Call<UserInfo> info(@Header("Authorization")String token);

//    修改用户信息
    @PUT("/prod-api/api/common/user")
    Call<>

//    获取新闻列表
    @GET("/prod-api/press/press/list")
    Call<News> test(@Query("type") Integer type);

    //    获取新闻分类
    @GET("/prod-api/press/category/list")
    Call<NewsList> list();

    class Msg {
         public String msg;
    }
//    手机充值
    @POST("/prod-api/api/common/balance/recharge")
    Call<Msg> money(@Header("Authorization") String token, @Query("money") Integer money);


}
