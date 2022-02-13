package com.example.ui1.ui.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.ui1.R;

public class BlankFragment1 extends Fragment {

    private ImageView im;
    Integer img;

    public BlankFragment1(Integer img) {
        this.img = img;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank1, container, false);
        im = inflate.findViewById(R.id.im);
        im.setImageResource(img);
        return inflate;
    }
}