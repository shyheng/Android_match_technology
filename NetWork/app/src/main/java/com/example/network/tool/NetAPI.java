package com.example.network.tool;

import com.example.network.entity.News;
import com.example.network.entity.NewsList;
import com.example.network.entity.Obj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetAPI {

    //    用户登录
    @POST("/prod-api/api/login")
    Call<Obj.Token> token(@Body Obj.Users users);

    //    用户注册
    @POST("/prod-api/api/register")
    Call<Obj.Msg> reg(@Body Obj.User user);

    //    查看用户信息
    @GET("/prod-api/api/common/user/getInfo")
    Call<Obj.UserInfo> info(@Header("Authorization") String token);

    //    修改用户信息
    @PUT("/prod-api/api/common/user")
    Call<Obj.Msg> putU(@Header("Authorization") String token, @Body Obj.User user);

    //    更改密码
    @PUT("/prod-api/api/common/user/resetPwd")
    Call<Obj.Msg> newPwd(@Header("Authorization") String token, @Body Obj.Pwd pwd);

    //    查询账号
    @GET("/prod-api/api/common/balance/list")
    Call<Obj.Bal> bal(@Header("Authorization") String token);

    //    手机充值
    @POST("/prod-api/api/common/balance/recharge")
    Call<Obj.Msg> money(@Header("Authorization") String token, @Query("money") Integer money);

    //    提交意见反馈
    @POST("/prod-api/api/common/feedback")
    Call<Obj.Msg> feed(@Header("Authorization") String token, @Body Obj.Feed feed);

    //    查看意见反馈
    @GET("/prod-api/api/common/feedback/list")
    Call<Obj.Feeds> feeds(@Header("Authorization") String token);

    //    获取意见反馈详情
    class FL {
        public Obj.Feeds.RowsBean data;
    }
    @GET("/prod-api/api/common/feedback/{id}")
    Call<FL> fl(@Header("Authorization")String token, @Path("id")Integer id);

    //    获取新闻分类
    @GET("/prod-api/press/category/list")
    Call<NewsList> list();

    class CL{
        public int code;
        public String msg;
        public String total;
        public List<RowsBean> rows;

        public static class RowsBean {
            public int id;
            public String appType;
            public int newsId;
            public String content;
            public String commentDate;
            public int userId;
            public int likeNum;
            public String userName;
            public String newsTitle;
        }
    }
//    获取新闻评论列表
    @GET("/prod-api/press/comments/list")
    Call<CL> cl(@Query("newsId") Integer newsId);

    class LC{
        public int code;
        public DataBean data;
        public String msg;
        public static class DataBean {
            public int id;
            public String appType;
            public int newsId;
            public String content;
            public String commentDate;
            public int userId;
            public int likeNum;
            public String userName;
            public String newsTitle;
        }
    }
    //    获取新闻评论的详细信息
    @GET("/prod-api/press/comments/{id}")
    Call<LC> lc(@Path("id")Integer id);

//    新闻点赞
    @PUT("/prod-api/press/press/like/{id}")
    Call<Obj.Msg> pl(@Header("Authorization")String token,@Path("id")Integer id);

    //    获取新闻列表
    @GET("/prod-api/press/press/list")
    Call<News> test(@Query("type") Integer type);

//    根据id获取详细新闻
    @GET("/prod-api/press/press/{id}")
    Call<Obj.PP> pp(@Path("id")Integer id);

    class PC{
        public int newsId;
        public String content;
        public PC(int newsId, String content) {
            this.newsId = newsId;
            this.content = content;
        }
    }
//    发表新闻评论
    @POST("/prod-api/press/pressComment")
    Call<Obj.Msg> pc(@Header("Authorization")String token,@Body PC pc);

//    评论点赞
    @POST("/prod-api/press/pressComment/like/{id}")
    Call<Obj.Msg> pcl(@Header("Authorization")String token,@Path("id")Integer id);

    class Img{
        public List<RowsBean> rows;

        public static class RowsBean {
            public String advImg;
        }
    }
//    主页轮播图查询
    @GET("/prod-api/api/rotation/list")
    Call<Img> img(@Query("type")String type);

//    class File{
//        public int code;
//        public String fileName;
//        public String url;
//        public String msg;
//    }
//    @Multipart
//    @POST("/prod-api/common/upload")
//    Call<File> file();
    class met{

    public String msg;
    public int code;
    public DataBean data;

    public static class DataBean {
        public int id;
        public String name;
        public int code;
        public String imgUrl;
    }
}
    @GET("/prod-api/api/metro/city")
    Call<met> met();
}
