package com.example.banner.tool;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import static com.example.banner.tool.Net.ip;

public abstract class ImageLoader extends com.youth.banner.loader.ImageLoader {

    @Override
    public void displayImage(Context context, Object o, ImageView imageView) {
        Glide.with(context)
                .load(ip+o.toString())
//                .apply(RequestOptions.bitmapTransform(new GranularRoundedCorners(10,10,10,10)))
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(imageView);
    }

}
