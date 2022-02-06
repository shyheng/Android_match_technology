package com.example.network.ui;

import android.os.Bundle;

import com.example.network.R;
import com.example.network.tool.Net;
import com.example.network.tool.NetAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
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
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        String token = getSharedPreferences("token",MODE_PRIVATE).getString("token", "");
        netAPI.money(token,20).enqueue(new Net<NetAPI.Msg>() {
            @Override
            public void onResponse(Call<NetAPI.Msg> call, Response<NetAPI.Msg> response) {
                System.out.println(response.body().getMsg());
                System.out.println(response.body().getCode());
            }
        });
    }

}