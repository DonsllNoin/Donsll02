package com.example.donsll02.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpbinService {

    @POST("post")
    @FormUrlEncoded  // 表单提交方式（ Field 表示提交的参数的名字 ）
    Call<ResponseBody> post(@Field("username") String userName, @Field("password") String pwd);

    @GET("get")
    Call<ResponseBody> get(@Query("username") String userName, @Query("password") String pwd);

}
