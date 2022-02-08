package com.example.banner.model;

import com.example.banner.tool.NetAPI;

import java.util.List;

public class ZY {
    public List<R> rows;
    class R {
        String advImg;
        @Override
        public String toString() {
            return advImg;
        }
    }
}
