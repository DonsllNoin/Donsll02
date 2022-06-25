package com.example.donsll02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.donsll02.Fragment.MainFragmentActivity;
import com.example.donsll02.Fragment.MainFragmentActivity2;
import com.example.donsll02.ViewPager.ViewPagerActivity;
import com.example.donsll02.Wechat.MainWechatActivity;


public class MainActivity extends AppCompatActivity {

    private Button fragment;
    private Button fragment2;
    private Button ViewPager;
    private Button Wechat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = findViewById(R.id.mBtn_fragment);
        fragment2 = findViewById(R.id.mBtn_fragmentChange);
        ViewPager = findViewById(R.id.mBtn_ViewPager);
        Wechat = findViewById(R.id.mBtn_Wechat);

        OnClick onClick = new OnClick();

        fragment.setOnClickListener(onClick);
        fragment2.setOnClickListener(onClick);
        ViewPager.setOnClickListener(onClick);
        Wechat.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent;

            switch (view.getId()){
                case R.id.mBtn_fragment:
                    intent = new Intent(MainActivity.this, MainFragmentActivity.class);
                    startActivity(intent);
                    break;

                case R.id.mBtn_fragmentChange:
                    intent = new Intent(MainActivity.this, MainFragmentActivity2.class);
                    startActivity(intent);
                    break;

                case R.id.mBtn_ViewPager:
                    intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                    startActivity(intent);
                    break;

                case R.id.mBtn_Wechat:
                    intent = new Intent(MainActivity.this, MainWechatActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}