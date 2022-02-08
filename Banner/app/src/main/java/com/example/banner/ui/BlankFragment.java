package com.example.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.banner.R;


public class BlankFragment extends Fragment {

    Integer image;

    public BlankFragment(Integer image) {
        this.image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        ImageView img = inflate.findViewById(R.id.img);
        img.setImageResource(image);
        return inflate;
    }
}