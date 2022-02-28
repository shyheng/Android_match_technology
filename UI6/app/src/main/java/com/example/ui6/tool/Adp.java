package com.example.ui6.tool;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class Adp extends BaseAdapter {

    List list = new ArrayList();
    int i = 0;

    public Adp(List list) {
        this.list = list;
    }

    public Adp(int i) {
        this.i = i;
    }

    @Override
    public int getCount() {
        if (list.isEmpty()){
            return i;
        }else {
            return list.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
