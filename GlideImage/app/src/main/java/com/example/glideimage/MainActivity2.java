package com.example.glideimage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity2 extends AppCompatActivity {

    private GridView theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        theme.setAdapter(new Adapter(4) {
            class ViewHolder {
                public View rootView;
                public ImageView img;
                public TextView te;
                public ConstraintLayout wzb;
                public ViewHolder(View rootView) {
                    this.rootView = rootView;
                    this.img = (ImageView) rootView.findViewById(R.id.img);
                    this.te = (TextView) rootView.findViewById(R.id.te);
                    this.wzb = (ConstraintLayout) rootView.findViewById(R.id.wzb);
                }

            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = new ViewHolder(View.inflate(MainActivity2.this, R.layout.item, null));
                Glide.with(getApplicationContext())
                        .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2109242129504953-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646557517&t=7c9bd27f40ca4f0921d755c3544958c0")
                        .apply(RequestOptions.bitmapTransform(new GranularRoundedCorners(50, 50, 0, 0)))
                        .into(viewHolder.img);
                viewHolder.img.setScaleType(ImageView.ScaleType.FIT_XY);


                int i = Color.parseColor("#000000");
                viewHolder.te.setTextColor(i);
                viewHolder.te.setText("美女");

                viewHolder.wzb.setBackgroundResource(R.drawable.yuanjiao);
                viewHolder.wzb.setElevation(10);
                return viewHolder.rootView;
            }
        });

        theme.setNumColumns(2);
        theme.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        theme = (GridView) findViewById(R.id.theme);
    }
}