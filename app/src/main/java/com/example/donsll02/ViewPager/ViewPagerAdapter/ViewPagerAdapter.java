package com.example.donsll02.ViewPager.ViewPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donsll02.R;

import java.util.ArrayList;
import java.util.List;

/*
*
*       ViewPagerViewHolder ：用来临时存储每次返回回来的 View。
*
*       适配器（ Adapter ） 和 临时存储器（ ViewHolder ）都用自己的
*
* */

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private List<String> titles = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();


    public ViewPagerAdapter() {
        titles.add("我");
        titles.add("爱");
        titles.add("张");
        titles.add("诺");
        titles.add("茵");

        colors.add(R.color.teal_200);
        colors.add(R.color.teal_700);
        colors.add(R.color.purple_200);
        colors.add(R.color.purple_500);
        colors.add(R.color.purple_700);


    }

    @NonNull
    @Override
    // 创建 初始化 的页面 ，引入 xml ，因此需要用 Inflater 进行解析来导入
    public ViewPagerAdapter.ViewPagerViewHolder
                    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pager, parent, false));

    }

    // 可以实现 每个页面 展示不同的内容
    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.mTv.setText(titles.get(position));
        // 这里的 color 是一个 资源 ，而不是一个像 #ff9944 这种的颜色
        holder.mContainer.setBackgroundResource(colors.get(position));
    }

    // 可以滚动的页面数
    @Override
    public int getItemCount() {
        return 5;
    }


    class ViewPagerViewHolder extends RecyclerView.ViewHolder{

        private TextView mTv;
        private RelativeLayout mContainer;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tvTitle);
        }
    }

}
