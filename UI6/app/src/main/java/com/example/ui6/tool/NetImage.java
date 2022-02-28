package com.example.ui6.tool;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import static com.example.ui6.tool.Net.ip;

public class NetImage extends ImageLoader {
    @Override
    public void displayImage(Context context, Object o, ImageView imageView) {
        Glide.with(context).load(ip+o).into(imageView);
    }
}
