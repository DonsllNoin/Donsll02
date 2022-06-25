package com.example.donsll02.Glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.donsll02.R;

public class GlideActivity extends AppCompatActivity {

    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        iv1 = findViewById(R.id.glide_iv_1);

        // 这里是报错时显示的占位符 ( 必须写在创建 Glide 之前 )
        RequestOptions requestOptions = new RequestOptions();
//                .placeholder(R.drawable.hold)                 // 正在加载图片时显示的图标
//                .error(R.drawable.error)                      // 图片显示错误时显示的图标
//                .fallback(R.drawable.fallback)                // 请求为空时显示的图标
//                .override(100,100);                           // 将显示的图片写死

        // 使得交叉淡入时，占位符会消失
        DrawableCrossFadeFactory factory =
                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        Glide.with(this)
        .load("https://wx2.sinaimg.cn/orj360/008nFUrkgy1gywftq9jqkj313c13cgwv.jpg")
        .apply(requestOptions)

        // 引入交叉淡入
        .transition(DrawableTransitionOptions.withCrossFade(factory))

        // 边角变换
        .transform(new CircleCrop())
        .into(iv1);

    }
}