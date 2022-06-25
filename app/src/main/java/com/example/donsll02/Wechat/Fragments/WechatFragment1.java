package com.example.donsll02.Wechat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.donsll02.R;

/**
 *
 *          这里只需要定义 一个 Fragment ，因为界面都是一样的 ，
 *          只是里面的 字 不一样而已
 *
 * */

public class WechatFragment1 extends Fragment {

    private static final String ARG_TEXT = "param1";

    private String mTextString;

    private View rootView;

    public WechatFragment1() {
        // Required empty public constructor
    }

    // 这里是 Fragment 与 Activity 通信的方法，Activity 直接调用传参就行了
    public static WechatFragment1 newInstance(String param1) {
        WechatFragment1 fragment = new WechatFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    // 接收从 Activity 中传过来的 Bundle（ 动态传参内容 ）
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTextString = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    // 创建 Fragment 页面
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 这个如果直接 return 解析的话，那么每次切回这页面就要解析一遍，太浪费资源了
        // 所以可以直接创建一个变量把这个解析过后的 xml 接住

        if (rootView == null){
            rootView = inflater.inflate(R.layout.fragment_wechat1, container, false);
        }

        initView();

        return rootView;
    }

    // 初始化 Fragment 界面
    private void initView() {

        TextView textView = rootView.findViewById(R.id.wechat_TextView_1);
        textView.setText(mTextString);

    }
}