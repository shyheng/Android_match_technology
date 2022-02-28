package com.example.ui6;

import android.app.Application;
import android.content.Intent;

import com.example.ui6.ui.MainActivity;

public class APP extends Application {
    @Override
    public void onCreate() {
        System.out.println("shy");
        startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        super.onCreate();
    }
}
