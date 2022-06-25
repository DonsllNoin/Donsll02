package com.example.donsll02.Wechat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

// FragmentStateAdapter 是专门用来让 ViewPager2 来适配 Fragment 的
public class MyFragmentPagerAdapter extends FragmentStateAdapter {

    // 在调用这个适配器的时候需要把 Fragment 给传进来
    List<Fragment> fragmentList = new ArrayList<>();

    // 构造函数
    public MyFragmentPagerAdapter(@NonNull FragmentManager fragmentManager,
                                  @NonNull Lifecycle lifecycle,
                                  List<Fragment> fragments) {

        super(fragmentManager, lifecycle);
        fragmentList = fragments;
    }

    @NonNull
    @Override
    // 创建 Fragment 页面
    public Fragment createFragment(int position) {
        // 滑到那个就创建哪个
        return fragmentList.get(position);
    }

    // 页数
    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
