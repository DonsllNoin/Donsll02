package com.example.donsll02.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.donsll02.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    private Button button1, button2;
    private Retrofit retrofit;
    private HttpbinService httpbinService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        button1 = findViewById(R.id.retrofit_btn1);
        button2 = findViewById(R.id.retrofit_btn2);

        // 按钮点击事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAsync(v);
            }
        });

        // 创建 retrofit 对象（ 绑定服务器地址 ）
        retrofit = new Retrofit.Builder().baseUrl("https://www.httpbin.org/").build();

        // 创建 httpbinService 对象
        httpbinService = retrofit.create(HttpbinService.class);


    }

    // 使用 retrofit 来提交表单
    public void postAsync(View view){

        // 创建 请求体
        Call<ResponseBody> call = httpbinService.post("donsll", "123");

        // 创建 发送 并 接收
        call.enqueue(new Callback<ResponseBody>() {

            // post 完成时的响应
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    Log.i(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }
}