package com.example.banner;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.banner.ui.MainActivity;
import com.example.banner.ui.MainActivity2;

public class APP extends Application {
    @Override
    public void onCreate() {
        if (getSharedPreferences("main",MODE_PRIVATE).getBoolean("m",false)){
            startActivity(new Intent(getApplicationContext(), MainActivity2.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }else {
            SharedPreferences sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("m",true);
            edit.commit();
            startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }

        super.onCreate();
    }
}
