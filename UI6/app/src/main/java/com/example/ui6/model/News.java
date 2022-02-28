package com.example.ui6.model;

import java.util.List;

public class News {

    public int code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        public int id;
        public String cover;
        public String title;
        public String subTitle;
        public String content;
        public String status;
        public String publishDate;
        public Object tags;
        public int commentNum;
        public int likeNum;
        public int readNum;
        public String type;
        public String top;
        public String hot;
    }
}
