package com.example.base.nethelper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class NetWorker {
    private static NetWorker instance;
    private Retrofit retrofit;

    static {
        instance = new NetWorker();
    }

    private NetWorker() {
    }

    public static OkHttpClient getClient(Context context){
        final String token = context.getSharedPreferences("Token",MODE_PRIVATE).getString("token",null);
        Log.d("",token);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        Request request = original.newBuilder()
                                .addHeader("userToken",token)
                                .addHeader("Content-Type","application/json")
                                .method(original.method(),original.body())
                                .build();

                        return chain.proceed(request);

                    }
                })
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        return  client;

    }


    // 构建一个Retrofit
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null)
            return instance.retrofit;



        Retrofit.Builder builder = new Retrofit.Builder();

        // 设置电脑链接
        instance.retrofit = builder.baseUrl("http://10.71.1.13:8080/")
                // 设置client

                // 设置Json解析器
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        return instance.retrofit;

    }

    public static Retrofit getRetrofit(Context context) {
        if (instance.retrofit != null)
            return instance.retrofit;



        Retrofit.Builder builder = new Retrofit.Builder();

        // 设置电脑链接
        instance.retrofit = builder.baseUrl("http://10.71.1.13:8080/")
                // 设置client

                // 设置Json解析器
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(getClient(context))
                .build();


        return instance.retrofit;

    }

    /**
     * 返回一个请求代理
     *
     * @return RemoteService
     */
//    public static RemoteService remote() {
//        return Network.getRetrofit().create(RemoteService.class);
//    }

}
