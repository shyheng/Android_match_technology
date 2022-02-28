package com.example.ui6.ui.index.ui.home;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.ui6.R;
import com.example.ui6.model.News;
import com.example.ui6.model.NewsList;
import com.example.ui6.model.Press;
import com.example.ui6.model.Rotation;
import com.example.ui6.model.Ser;
import com.example.ui6.tool.Adp;
import com.example.ui6.tool.FragmentID;
import com.example.ui6.tool.Net;
import com.example.ui6.tool.NetImage;
import com.example.ui6.tool.SG;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    private Banner bann;
    private SG theme;
    private SG ser;
    private SG news;
    private SG news_l;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        FragmentID.view = root;

        bann = (Banner) FragmentID.find(R.id.bann);
        bann.setImageLoader(new NetImage());
        Net.netAPI.rot("2").enqueue(new Net<Rotation>() {
            @Override
            public void onResponse(Call<Rotation> call, Response<Rotation> response) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < response.body().rows.size(); i++) {
                    list.add(response.body().rows.get(i).advImg);
                }
                bann.setImages(list);
                bann.start();
            }
        });

        ser = (SG) FragmentID.find(R.id.ser);
        Net.netAPI.ser().enqueue(new Net<Ser>() {
            @Override
            public void onResponse(Call<Ser> call, final Response<Ser> response) {
                ser.setAdapter(new Adp(10) {
                    class ViewHolder {
                        public View rootView;
                        public ImageView image;
                        public TextView text;

                        public ViewHolder(View rootView) {
                            this.rootView = rootView;
                            this.image = (ImageView) rootView.findViewById(R.id.image);
                            this.text = (TextView) rootView.findViewById(R.id.text);
                        }

                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        ViewHolder viewHolder = new ViewHolder(View.inflate(getContext(), R.layout.item_ser, null));
                        if (position <= 8) {
                            Glide.with(viewHolder.rootView).load(ip + response.body().rows.get(position).imgUrl).into(viewHolder.image);
                            viewHolder.text.setText(response.body().rows.get(position).serviceName);
                        } else {
                            viewHolder.image.setImageResource(R.drawable.ic_dashboard_black_24dp);
                            viewHolder.text.setText("全部服务");
                        }

                        return viewHolder.rootView;
                    }
                });
            }
        });

        theme = (SG) FragmentID.find(R.id.theme);
        Net.netAPI.news().enqueue(new Net<News>() {
            @Override
            public void onResponse(Call<News> call, final Response<News> response) {
                theme.setAdapter(new Adp(4) {
                    class ViewHolder {
                        public View rootView;
                        public ImageView image;
                        public TextView text;

                        public ViewHolder(View rootView) {
                            this.rootView = rootView;
                            this.image = (ImageView) rootView.findViewById(R.id.image);
                            this.text = (TextView) rootView.findViewById(R.id.text);
                        }
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        ViewHolder viewHolder = new ViewHolder(View.inflate(getContext(), R.layout.item_theme, null));
                        Glide.with(viewHolder.rootView).load(ip + response.body().rows.get(position).cover).into(viewHolder.image);
                        viewHolder.text.setText(Html.fromHtml(response.body().rows.get(position).content));
                        return viewHolder.rootView;
                    }
                });
            }
        });

        news = (SG) FragmentID.find(R.id.news);
        news_l = (SG) FragmentID.find(R.id.news_l);

        Net.netAPI.newsList().enqueue(new Net<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, final Response<NewsList> response) {
                news.setNumColumns(response.body().data.size());
                news.setAdapter(new Adp(response.body().data) {
                    class ViewHolder {
                        public View rootView;
                        public TextView tv;

                        public ViewHolder(View rootView) {
                            this.rootView = rootView;
                            this.tv = (TextView) rootView.findViewById(R.id.tv);
                        }
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        ViewHolder viewHolder = new ViewHolder(View.inflate(getContext(), R.layout.item_newlist, null));
                        viewHolder.tv.setText(response.body().data.get(position).name);
                        return viewHolder.rootView;
                    }
                });
                newsList(response,0);

                news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        newsList(response,position);
                    }
                });

            }

            private void newsList(Response<NewsList> response,int i) {
                netAPI.press(String.valueOf(response.body().data.get(i).id)).enqueue(new Net<Press>() {
                    @Override
                    public void onResponse(Call<Press> call, final Response<Press> response) {
                        news_l.setAdapter(new Adp(response.body().rows) {
                            class ViewHolder {
                                public View rootView;
                                public ImageView news;
                                public TextView tv_t;

                                public ViewHolder(View rootView) {
                                    this.rootView = rootView;
                                    this.news = (ImageView) rootView.findViewById(R.id.news);
                                    this.tv_t = (TextView) rootView.findViewById(R.id.tv_t);
                                }

                            }

                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                ViewHolder viewHolder = new ViewHolder(View.inflate(getContext(), R.layout.item_news_list, null));
                                Glide.with(viewHolder.rootView).load(ip+response.body().rows.get(position).cover).into(viewHolder.news);
                                viewHolder.tv_t.setText(response.body().rows.get(position).title);
                                return viewHolder.rootView;
                            }
                        });
                    }
                });
            }
        });


        return root;
    }


}