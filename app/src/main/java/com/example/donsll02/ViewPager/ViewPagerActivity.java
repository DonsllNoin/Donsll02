package com.example.donsll02.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.donsll02.R;
import com.example.donsll02.ViewPager.ViewPagerAdapter.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager2 = findViewById(R.id.viewPager);

        // 因为 viewpager 是一个容器，而这个容器不知道要装哪些东西
        // 因此就需要一个适配器 adapter 来编辑适配的东西
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager2.setAdapter(viewPagerAdapter);

    }
}