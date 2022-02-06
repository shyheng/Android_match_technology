package com.example.network.tool;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.network.R;
import com.example.network.entity.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.network.tool.Net.netAPI;

public class NewsListNet {
    public static void news(int i, final Context context, final GridView gv) {
        netAPI.test(i).enqueue(new Net<News>() {
            @Override
            public void onResponse(Call<News> call, final Response<News> response) {
                final List<News.RowsBean> rows = response.body().getRows();
                if (!rows.isEmpty()){
                    gv.setAdapter(new Adapter(rows) {
                        class ViewHolder {
                            public View rootView;
                            public ImageView im;
                            public TextView ti;
                            public TextView con;

                            public ViewHolder(View rootView) {
                                this.rootView = rootView;
                                this.im = (ImageView) rootView.findViewById(R.id.im);
                                this.ti = (TextView) rootView.findViewById(R.id.ti);
                                this.con = (TextView) rootView.findViewById(R.id.con);
                            }

                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item_news, null));
                            Glide.with(context).load(url+rows.get(position).getCover()).into(viewHolder.im);
                            viewHolder.ti.setText(rows.get(position).getTitle());
                            viewHolder.con.setText(Html.fromHtml(rows.get(position).getContent()));
                            return viewHolder.rootView;
                        }
                    });
                }
            }
        });
    }
}
