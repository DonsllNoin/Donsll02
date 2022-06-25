package com.example.donsll02.LitePal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.donsll02.R;

public class LitePalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);

        Book book = new Book();
        // 让 pages 列里的所有值都恢复成默认值
        book.setToDefault("pages");
        // 括号里没有限定的话，就是默认选中所有
        book.updateAll();

    }
}