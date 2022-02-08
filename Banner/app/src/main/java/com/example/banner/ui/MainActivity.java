package com.example.banner.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.banner.R;
import com.example.banner.ui.BlankFragment;
import com.example.banner.ui.BlankFragment2;

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
        fragments.add(new BlankFragment(R.drawable.guide1));
        fragments.add(new BlankFragment(R.drawable.guide2));
        fragments.add(new BlankFragment(R.drawable.guide3));
        fragments.add(new BlankFragment(R.drawable.guide4));
        fragments.add(new BlankFragment2());

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