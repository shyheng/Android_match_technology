package com.example.banner.tool;

import android.content.Context;
import android.widget.Toast;

public class SToast {
    public static void toast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
