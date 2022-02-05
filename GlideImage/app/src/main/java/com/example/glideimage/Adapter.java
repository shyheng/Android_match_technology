package com.example.glideimage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class Adapter extends BaseAdapter {

    List list = new ArrayList();
    int i;

    public Adapter(List list) {
        this.list = list;
    }

    public Adapter(int i) {
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
