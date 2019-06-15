package com.example.yangyang.learnmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.base.base.BaseActivity;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.activity.MainActivity;
import com.example.yangyang.learnmvp.activity.UserActivity;
import com.igexin.sdk.PushManager;

public class LaunchActivity extends BaseActivity {



    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_launch;
    }

    @Override
    protected void initData() {
        super.initData();
        judge();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PushManager.getInstance().initialize(this, AppPushService.class);
//        // 推送注册消息接收服务
//        PushManager.getInstance().registerPushIntentService(this, AppMessageReceiverService.class);
        PushManager.getInstance().initialize(getApplicationContext(),DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(getApplicationContext(), DemoIntentService.class);

    }

    private void judge(){

        if (Common.getToken(this) == null){
            UserActivity.GoUserActivity(this);
        }
        else {
            MainActivity.GoMainActivity(this);
        }





    }
}
