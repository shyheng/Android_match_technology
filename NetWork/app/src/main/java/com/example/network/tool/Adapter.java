package com.example.network.tool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class Adapter extends BaseAdapter {

    List list;
    int anInt;

    public Adapter(List list) {
        this.list = list;
    }

    public Adapter(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public int getCount() {
        if (list.isEmpty()){
            return anInt;
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
