package com.example.yangyang.learnmvp;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.igexin.sdk.PushManager;
import com.raizlabs.android.dbflow.config.FlowManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);

        getPushId(getApplicationContext());

    }


    private static App instance;

    /**
     * 外部获取单例
     *
     * @return Application
     */
    public static App getInstance() {
        return instance;
    }

    public static String getPushId(Context context ){
        SharedPreferences sharedPreferences = context.getSharedPreferences("GET_ID",MODE_PRIVATE);
        return sharedPreferences.getString("pushId",null);


    }


}
