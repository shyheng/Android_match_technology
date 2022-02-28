package com.example.ui6.model;

import java.util.List;

public class NewsList {

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        public Object searchValue;
        public Object createBy;
        public Object createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String appType;
        public String name;
        public int sort;
        public String status;
        public Object parentId;

        public static class ParamsBean {
        }
    }
}
