package com.example.banner.ui;

import android.os.Bundle;
import android.view.Menu;

import com.example.banner.R;
import com.example.banner.tool.SToast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }
    long l ;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis()-l>2000){
            SToast.toast(getApplicationContext(),"退出");
            l = System.currentTimeMillis();
        }else {
            finish();
        }
    }
}