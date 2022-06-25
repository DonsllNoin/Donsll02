package com.example.donsll02.OkHttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.donsll02.R;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private static final String TAG = "OkHttpActivity";
    private OkHttpClient okHttpClient;
    private Button button1, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        okHttpClient = new OkHttpClient();

        button1 = findViewById(R.id.okhttp_btn_1);
        button2 = findViewById(R.id.okhttp_btn_2);
        button3 = findViewById(R.id.okhttp_btn_3);
        button4 = findViewById(R.id.okhttp_btn_4);
        button5 = findViewById(R.id.okhttp_btn_5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSync(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAsync(v);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postSync(v);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAsync(v);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    uploadFileTest(v);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    // Get 同步请求
    public void getSync(View view){
        // 在 Android 中使用 同步网络请求 要使用一个线程进行完成
        // 因为如果没有线程的话，程序就会阻塞在请求的那个地方
        new Thread(){
            @Override
            public void run() {
                super.run();
                // 创建请求对象的域名
                Request build = new Request.Builder().url("https://httpbin.org/get?a=1&b=2").build();

                // 调用请求工具来创建一个准备好请求的 Call 对象
                Call call = okHttpClient.newCall(build);
                try {

                    // 这里是等到 完成请求之后 得到的一个 响应
                    Response response = call.execute();

                    // 把服务器响应给我们的 字符串数据 打印出来（ 其他数据也可以 ）
                    Log.i(TAG, "getSync: " + response.body().string() );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    // Get 异步请求
    public void getAsync(View view){
        // 创建请求对象的域名
        Request build = new Request.Builder().url("https://httpbin.org/get?a=1&b=2").build();

        // 调用请求工具来创建一个准备好请求的 Call 对象
        Call call = okHttpClient.newCall(build);

        // 异步请求是调用 enqueue 方法
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                // onResponse 成功并不代表 成功连接上了网站 ，只能说明跟服务器连接成功了，但可能没有反应
                if(response.isSuccessful()){

                    // 200 - 300 之间表示成功
                    // 300 - 400 之间可能是重定向
                    // 400 - 500 之间表示没有成功, 服务器错误
                    String string = response.body().string();
                    Log.i(TAG, "onResponse: " + string);
                }
            }
        });
    }


    // Post 同步请求
    public void postSync(View view){
        new Thread(){
            @Override
            public void run() {
                super.run();
                // get 请求是要把参数放到 url 里面，而 post 请求要求把请求放在 请求体 里面 ( 最后记得 build )
                FormBody formBody = new FormBody.Builder()
                        .add("a", "1").add("b", "2").build();

                // 由于 Request 默认是返回的 get 请求，所以要手动改一下
                Request request = new Request.Builder().url("https://httpbin.org/post")
                                                                                .post(formBody).build();
                // 调用请求工具来创建一个准备好请求的 Call 对象
                Call call = okHttpClient.newCall(request);
                try {
                    // 这里是等到 完成请求之后 得到的一个 响应
                    Response response = call.execute();
                    // 把服务器响应给我们的 字符串数据 打印出来（ 其他数据也可以 ）
                    Log.i(TAG, "postSync: " + response.body().string() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    // Post 异步请求
    public void postAsync(View view){

        // get 请求是要把参数放到 url 里面，而 post 请求要求把请求放在 请求体 里面 ( 最后记得 build )
        FormBody formBody = new FormBody.Builder()
                .add("a", "1").add("b", "2").build();

        // 由于 Request 默认是返回的 get 请求，所以要手动改一下
        Request request = new Request.Builder().url("https://httpbin.org/post").post(formBody).build();

        // 调用请求工具来创建一个准备好请求的 Call 对象
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i(TAG, "onResponse: " + response.body().string());
            }
        });

    }

    // Post 上传文件
    public void uploadFileTest(View view) throws IOException {

        new Thread(){
            @Override
            public void run() {
                super.run();
                // 创建网络客户端实例
                OkHttpClient okHttpClient = new OkHttpClient();

                // 创建文件
                File file1 = new File("D:\\1.txt");
                File file2 = new File("D:\\2.txt");

                // 创建文件包( addFormDataPart 的括号不要弄少了 )
                MultipartBody multipartBody = new MultipartBody.Builder()
                        .addFormDataPart("file1", file1.getName(), RequestBody.create(file1, MediaType.parse("text/plain")))
                        .addFormDataPart("file2", file2.getName(), RequestBody.create(file2,MediaType.parse("text/plain")))
                        .addFormDataPart("a","1")
                        .build();

                // 创建请求包
                Request request = new Request.Builder().url("https://www.httpbin.org/post").post(multipartBody).build();

                // 包装成 call
                Call call = okHttpClient.newCall(request);

                try {
                    Response response = call.execute();
                    Log.i(TAG, "run: " + response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

}