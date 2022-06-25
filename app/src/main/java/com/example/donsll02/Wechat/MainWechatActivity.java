package com.example.donsll02.Wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.donsll02.R;
import com.example.donsll02.Wechat.Fragments.WechatFragment1;

import java.util.ArrayList;

public class MainWechatActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager2 viewPager2;
    private LinearLayout llChat, llContact, llFind, llMyself;
    private ImageView ivChat, ivContact, ivFind, ivMyself, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wechat);

        // 创建一个方法来专门初始化 ViewPager ：能实现 页面滑动 的功能
        initPager();
        initTabView();
    }

    // 初始化 Tab 栏
    private void initTabView() {
        llChat = findViewById(R.id.tab_wechat_message);
        llChat.setOnClickListener(MainWechatActivity.this);

        llContact = findViewById(R.id.tab_wechat_context);
        llContact.setOnClickListener(MainWechatActivity.this);

        llFind = findViewById(R.id.tab_wechat_find);
        llFind.setOnClickListener(MainWechatActivity.this);

        llMyself = findViewById(R.id.tab_wechat_myself);
        llMyself.setOnClickListener(MainWechatActivity.this);

        ivChat = findViewById(R.id.tab_wechat_iv1);
        ivContact = findViewById(R.id.tab_wechat_iv2);
        ivFind = findViewById(R.id.tab_wechat_iv3);
        ivMyself = findViewById(R.id.tab_wechat_iv4);

        // 默认选中
        ivChat.setSelected(true);
        ivCurrent = ivChat;

    }

    // 初始化滑动页面
    private void initPager() {

        viewPager2 = findViewById(R.id.id_viewpager);

        // 创建 Fragment 集合
        ArrayList<Fragment> fragments = new ArrayList<>();

        // 调用 Bundle 传参方法 来创建新的 Fragment
        fragments.add(WechatFragment1.newInstance("微信聊天"));
        fragments.add(WechatFragment1.newInstance("通讯录"));
        fragments.add(WechatFragment1.newInstance("发现"));
        fragments.add(WechatFragment1.newInstance("我的信息"));

        // 绑定适配器（ 适配 Fragment ）
        viewPager2.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                                                                    getLifecycle(), fragments));
        // 设置滑动的监听接口
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            // 滑动时的动画设置方法
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            // 页面滑动后，要选择哪个按钮
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    // 页面切换后选择的按钮
    private void changeTab(int position) {

        // 此时的 ivCurrent == ivChat ，当这个 Current 改变的时候，就是改变了 ivChat 的设置
        // 因为一切换页面就会调用这个方法，因此一切换之后，当前的选中就会消除，就开始重新选择
        ivCurrent.setSelected(false);

        switch (position){
            case R.id.tab_wechat_message:
                // setCurrentItem ：设置当前是哪个页面
                viewPager2.setCurrentItem(0);

            case 0 :
                ivChat.setSelected(true);
                ivCurrent = ivChat;         // 因为一切换页面就只有这一个被选中，因为一开始被清零了
                break;

            case R.id.tab_wechat_context:
                viewPager2.setCurrentItem(1);

            case 1 :
                ivContact.setSelected(true);
                ivCurrent = ivContact;
                break;

            case R.id.tab_wechat_find:
                viewPager2.setCurrentItem(2);

            case 2 :
                ivFind.setSelected(true);
                ivCurrent = ivFind;
                break;

            case R.id.tab_wechat_myself:
                viewPager2.setCurrentItem(3);

            case 3 :
                ivMyself.setSelected(true);
                ivCurrent = ivMyself;
                break;
        }
    }

    // 绑定 Tab 栏的点击事件
    @Override
    public void onClick(View v) {

        // 点击了之后，Tab 变色
        changeTab(v.getId());

    }
}