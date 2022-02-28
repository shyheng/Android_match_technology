package com.example.ui6.model;

import java.util.List;

public class Rotation {

    public String code;
    public String msg;
    public String total;
    public List<RowsBean> rows;

    public static class RowsBean {
        public int id;
        public int sort;
        public String advTitle;
        public String advImg;
        public String servModule;
        public int targetId;
        public String type;
    }
}
