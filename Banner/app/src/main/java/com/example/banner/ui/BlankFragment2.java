package com.example.banner.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.banner.R;


public class BlankFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank2, container, false);
        TextView tv = inflate.findViewById(R.id.ip);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText inputServer = new EditText(getContext());
                inputServer.setHint("格式127.0.0.1:8080");
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("设置IP端口").setView(inputServer)
                        .setNegativeButton("退出", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        inputServer.getText().toString();
                    }
                });
                builder.show();
            }
        });
        Button button = inflate.findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity2.class));
            }
        });
        return inflate;
    }
}