package com.example.ui6.model;

import java.util.List;

public class Ser {

    public int code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        public int id;
        public String serviceName;
        public String serviceDesc;
        public String serviceType;
        public String imgUrl;
        public String link;
        public int sort;
        public String isRecommend;
    }
}
