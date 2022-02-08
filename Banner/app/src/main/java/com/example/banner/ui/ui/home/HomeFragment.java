package com.example.banner.ui.ui.home;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.banner.R;
import com.example.banner.model.ZY;
import com.example.banner.tool.ImageLoader;
import com.example.banner.tool.Net;
import com.example.banner.tool.NetAPI;
import com.youth.banner.Banner;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.banner.tool.Net.net;

public class HomeFragment extends Fragment {


    private Banner ban;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        ban = root.findViewById(R.id.ban);
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle("请稍等");
        dialog.setMessage("正在为您全力加速");
        dialog.setCancelable(false);
        dialog.show();
        net.zy().enqueue(new Net<ZY>() {
            @Override
            public void onResponse(Call<ZY> call, Response<ZY> response) {

                ban.setImageLoader(new ImageLoader(){});
                ban.setImages(response.body().rows);
                ban.start();
                dialog.dismiss();
            }
        });


        return root;
    }

}