package com.example.network.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.network.R;
import com.example.network.assembly.SGrid;
import com.example.network.entity.News;
import com.example.network.entity.NewsList;
import com.example.network.entity.User;
import com.example.network.tool.Adapter;
import com.example.network.tool.Net;
import com.example.network.tool.NetAPI;
import com.example.network.tool.NewsListNet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;
import static com.example.network.tool.Net.token;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button6;
    private Button button5;
    private Button button4;
    private Button button3;
    private Button button2;
    private Button button;
    private SGrid gv;
    List<NewsList.DataBean> rows;
    int c = Color.parseColor("#00FFFF");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        netAPI.list().enqueue(new Net<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                rows = response.body().getData();
                if (!rows.isEmpty()) {
                    button.setText(rows.get(5).getName());
                    button2.setText(rows.get(4).getName());
                    button3.setText(rows.get(3).getName());
                    button4.setText(rows.get(2).getName());
                    button5.setText(rows.get(1).getName());
                    button6.setText(rows.get(0).getName());
                    NewsListNet.news(rows.get(0).getId(),getApplicationContext(),gv);
                }
            }
        });

    }

    private void initView() {

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        gv = findViewById(R.id.gv);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button6:
                NewsListNet.news(rows.get(0).getId(),getApplicationContext(),gv);
                break;
            case R.id.button5:
                NewsListNet.news(rows.get(1).getId(),getApplicationContext(),gv);
                break;
            case R.id.button4:
                NewsListNet.news(rows.get(2).getId(),getApplicationContext(),gv);
                break;
            case R.id.button3:
                NewsListNet.news(rows.get(3).getId(),getApplicationContext(),gv);
                break;
            case R.id.button2:
                NewsListNet.news(rows.get(4).getId(),getApplicationContext(),gv);
                break;
            case R.id.button:
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
                NewsListNet.news(rows.get(5).getId(),getApplicationContext(),gv);
                break;
        }
    }
}