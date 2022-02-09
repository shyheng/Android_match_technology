package com.example.network.ui.ui.home;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.network.R;
import com.example.network.entity.Obj;
import com.example.network.tool.Net;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;


public class HomeFragment extends Fragment {

    private TextView tv;
    private TextView tvc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tv = root.findViewById(R.id.tv);
        tvc = root.findViewById(R.id.tvc);
        netAPI.pp(29).enqueue(new Net<Obj.PP>() {
            @Override
            public void onResponse(Call<Obj.PP> call, Response<Obj.PP> response) {
                tv.setText(response.body().data.title);
                tvc.setText(Html.fromHtml(response.body().data.content));
            }
        });
        return root;
    }
}