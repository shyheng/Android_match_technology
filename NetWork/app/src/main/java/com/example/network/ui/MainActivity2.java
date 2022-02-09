package com.example.network.ui;

import android.os.Bundle;

import com.example.network.R;
import com.example.network.entity.Obj;

import com.example.network.tool.Net;
import com.example.network.tool.NetAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        String token = getSharedPreferences("token",MODE_PRIVATE).getString("token", "");
//        netAPI.money(token,20).enqueue(new Net<NetAPI.Msg>() {
//            @Override
//            public void onResponse(Call<NetAPI.Msg> call, Response<NetAPI.Msg> response) {
//                System.out.println(response.body().msg);
//            }
//        });

//        netAPI.info(token).enqueue(new Net<Obj.UserInfo>() {
//            @Override
//            public void onResponse(Call<Obj.UserInfo> call, Response<Obj.UserInfo> response) {
//                System.out.println(response.body().user.userId);
//                System.out.println(response.body().user.userName);
//                System.out.println(response.body().user.nickName);
//                System.out.println(response.body().user.phonenumber);
//                System.out.println(response.body().user.score);
//            }
//        });

//        netAPI.putU(token,new NetAPI.User("s",null,null,null,null)).enqueue(new Net<NetAPI.Msg>() {
//            @Override
//            public void onResponse(Call<NetAPI.Msg> call, Response<NetAPI.Msg> response) {
//                System.out.println(response.body().msg);
//            }
//        });


//        netAPI.bal(token).enqueue(new Net<Obj.Bal>() {
//            @Override
//            public void onResponse(Call<Obj.Bal> call, Response<Obj.Bal> response) {
//                for (int i = 0; i < response.body().rows.size(); i++) {
//                    System.out.println(response.body().msg);
//                    System.out.println(response.body().rows.get(i).event);
//                    System.out.println(response.body().rows.get(i).changeAmount);
//                    System.out.println(response.body().rows.get(i).changeType);
//                    System.out.println(response.body().rows.get(i).changeTime);
//                }
//            }
//        });

//        netAPI.feed(token,new Obj.Feed("好","真棒")).enqueue(new Net<Obj.Msg>() {
//            @Override
//            public void onResponse(Call<Obj.Msg> call, Response<Obj.Msg> response) {
//                System.out.println(response.body().msg);
//            }
//        });

//        netAPI.feeds(token).enqueue(new Net<Obj.Feeds>() {
//            @Override
//            public void onResponse(Call<Obj.Feeds> call, Response<Obj.Feeds> response) {
//                for (int i = 0; i < response.body().rows.size(); i++) {
//                    System.out.print(response.body().rows.get(i).id);
//                    System.out.print(response.body().rows.get(i).appType);
//                    System.out.print(response.body().rows.get(i).title);
//                    System.out.print(response.body().rows.get(i).content);
//                    System.out.println();
//                }
//            }
//        });

//        netAPI.fl(token,56).enqueue(new Net<NetAPI.FL>() {
//            @Override
//            public void onResponse(Call<NetAPI.FL> call, Response<NetAPI.FL> response) {
//                System.out.println(response.body().data.title);
//                System.out.println(response.body().data.content);
//            }
//        });

//        netAPI.cl(29).enqueue(new Net<NetAPI.CL>() {
//            @Override
//            public void onResponse(Call<NetAPI.CL> call, Response<NetAPI.CL> response) {
//                System.out.println(response.body().msg);
//            }
//        });

//        netAPI.lc(29).enqueue(new Net<NetAPI.LC>() {
//            @Override
//            public void onResponse(Call<NetAPI.LC> call, Response<NetAPI.LC> response) {
//                System.out.println(response.body().msg);
//            }
//        });

//        netAPI.pl(token,29).enqueue(new Net<Obj.Msg>() {
//            @Override
//            public void onResponse(Call<Obj.Msg> call, Response<Obj.Msg> response) {
//                System.out.println(response.body().msg);
//            }
//        });

//        netAPI.pc(token,new NetAPI.PC(29,"这好")).enqueue(new Net<Obj.Msg>() {
//            @Override
//            public void onResponse(Call<Obj.Msg> call, Response<Obj.Msg> response) {
//                System.out.println(response.body().msg);
//            }
//        });

        netAPI.img("2").enqueue(new Net<NetAPI.Img>() {
            @Override
            public void onResponse(Call<NetAPI.Img> call, Response<NetAPI.Img> response) {
                for (int i = 0; i < response.body().rows.size(); i++) {
                    System.out.println(response.body().rows.get(i).advImg);
                }
            }
        });
    }

}