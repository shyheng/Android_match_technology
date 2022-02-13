package com.example.ui1.ui.g;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ui1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment1(R.drawable.guide1));
        fragments.add(new BlankFragment1(R.drawable.guide2));
        fragments.add(new BlankFragment1(R.drawable.guide3));
        fragments.add(new BlankFragment1(R.drawable.guide4));
        fragments.add(new BlankFragment2(R.drawable.guide5));
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}