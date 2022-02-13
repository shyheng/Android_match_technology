package com.example.ui1.ui.g;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.ui1.R;
import com.example.ui1.ui.inde.IndexActivity;

public class BlankFragment2 extends Fragment {
    private ImageView im;
    private Button but;
    Integer img;
    private TextView tv;

    public BlankFragment2(Integer img) {
        this.img = img;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank2, container, false);
        im = inflate.findViewById(R.id.im);
        but = inflate.findViewById(R.id.but);
        tv = inflate.findViewById(R.id.tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("设置IP端口").setView(editText)
                        .setNegativeButton("退出",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = editText.getText().toString();
                    }
                });
                builder.show();
            }
        });
        im.setImageResource(img);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), IndexActivity.class));
            }
        });
        return inflate;
    }
}