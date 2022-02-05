package com.example.glideimage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.RequestOptions;


public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private TextView te;
    private ConstraintLayout wzb;
    private SGridView theme;
    private SGridView theme1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Glide.with(this)
                .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2109242129504953-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646557517&t=7c9bd27f40ca4f0921d755c3544958c0")
                .apply(RequestOptions.bitmapTransform(new GranularRoundedCorners(50, 50, 0, 0)))
                .into(img);
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        int i = Color.parseColor("#000000");
        te.setTextColor(i);
        te.setText("美女");

        wzb.setBackgroundResource(R.drawable.yuanjiao);
        wzb.setElevation(40);

        theme.setAdapter(new BaseAdapter() {
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
            public int getCount() {
                return 4;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = new ViewHolder(View.inflate(MainActivity.this, R.layout.item, null));
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
        theme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });


        theme1.setAdapter(new BaseAdapter() {
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
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = new ViewHolder(View.inflate(MainActivity.this, R.layout.item, null));
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

        theme1.setNumColumns(2);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        te = (TextView) findViewById(R.id.te);
        wzb = (ConstraintLayout) findViewById(R.id.wzb);
        theme = (SGridView) findViewById(R.id.theme);
        theme1 = (SGridView) findViewById(R.id.theme1);
    }

    long time;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - time > 2000) {
            Toast.makeText(this, "再按退出", Toast.LENGTH_SHORT).show();
            time = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}