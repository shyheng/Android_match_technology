package com.example.network.entity;

import java.util.List;

public class Obj {
    public static class Users {
        public Users(String username, String password) {
            this.username = username;
            this.password = password;
        }
        String username;
        String password;
    }
    public class Token {
        public String token;
    }

    public class UserInfo {
        public Obj.User user;
    }

    public class User{
        public User(String nickName, String phonenumber, String sex, String email, String idCard) {
            this.nickName = nickName;
            this.phonenumber = phonenumber;
            this.sex = sex;
            this.email = email;
            this.idCard = idCard;
        }

        public Integer userId;
        public String avatar;
        public String userName;
        public String nickName;
        public String password;
        public String phonenumber;
        public String sex;
        public String email;
        public String idCard;
        public String balance;
        public String score;
    }

    public class Msg {
        public String msg;
    }
    public class Pwd{
        public String newPassword;
        public String oldPassword;
    }
    public class Bal{
        public int total;
        public int code;
        public String msg;
        public List<RowsBean> rows;
        public class RowsBean {
            public int id;
            public Object appType;
            public int userId;
            public String event;
            public int changeAmount;
            public String changeType;
            public Object userName;
            public String changeTime;
        }
    }

    public static class Feed{
        public String content;
        public String title;

        public Feed(String content, String title) {
            this.content = content;
            this.title = title;
        }
    }
    public static class Feeds{

        public String code;
        public String msg;
        public String total;
        public List<RowsBean> rows;

        public static class RowsBean {
            public int id;
            public String appType;
            public String title;
            public String content;
            public int userId;
        }
    }

    public class PP{

        public int code;
        public DataBean data;
        public String msg;

        public class DataBean {
            public int id;
            public String appType;
            public String cover;
            public String title;
            public String subTitle;
            public String content;
            public String status;
            public String publishDate;
            public Object tags;
            public Object commentNum;
            public int likeNum;
            public Object readNum;
            public String type;
            public String top;
            public String hot;
        }
    }
}
