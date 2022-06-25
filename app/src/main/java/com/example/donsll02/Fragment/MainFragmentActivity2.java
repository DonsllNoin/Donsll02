package com.example.donsll02.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.donsll02.Fragment.Fragment.BlankFragment1;
import com.example.donsll02.Fragment.Fragment.ItemFragment;
import com.example.donsll02.R;

/*
*
*       通过一个按钮将这个页面的 fragment 替换掉
*
*/

public class MainFragmentActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment2);

        // 绑定按钮
        Button button1 = findViewById(R.id.mBtn_change1);
        Button button2 = findViewById(R.id.mBtn_change2);
        Button button3 = findViewById(R.id.mBtn_transport);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mBtn_change1:
                // 编辑按钮功能 ( 切换页面 )
                replaceFragment1(new BlankFragment1());

            case R.id.mBtn_change2:
                // 编辑按钮功能 ( 切换页面 )
                replaceFragment1(new ItemFragment());

            case R.id.mBtn_transport:
                // 展示 Activity 向 Fragment 中传输值
                Bundle bundle = new Bundle();
                bundle.putString("message","传输的值");
                BlankFragment1 bf = new BlankFragment1();

                // 将 bundle 装载到 BlankFragment 中的 Argument 中。
                bf.setArguments(bundle);

                // 切换页面
                replaceFragment1(bf);
        }
    }

    private void replaceFragment1(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 开始替换页面, 加入栈功能, 加入容错率
        fragmentTransaction.replace(R.id.fl_01, fragment)
                .addToBackStack(null)               // 加上这个代码之后就会出现 onDestoryView
                .commitAllowingStateLoss();

    }
}