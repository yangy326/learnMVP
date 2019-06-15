package com.example.yangyang.learnmvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.DemoIntentService;
import com.example.yangyang.learnmvp.DemoPushService;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.fragment.user.LoginFragment;
import com.example.yangyang.learnmvp.fragment.user.RegisterFragment;
import com.example.yangyang.learnmvp.fragment.user.UserTrigger;
import com.igexin.sdk.PushManager;

public class UserActivity extends BaseActivity implements UserTrigger{

    private BaseFragment mcurrentFragment , loginFragment , registerFragment;





    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initWindows() {
        super.initWindows();

        mcurrentFragment = registerFragment = new RegisterFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mcurrentFragment)
                .commit();

    }

    @Override
    public void triggerView() {

        BaseFragment fragment;
        if (mcurrentFragment == registerFragment) {
            if (loginFragment == null) {
                //默认情况下为null，
                //第一次之后就不为null了
                loginFragment = new LoginFragment();
            }
            fragment = loginFragment;
        } else {
            // 因为默认请求下mLoginFragment已经赋值，无须判断null
            fragment = registerFragment;
        }

        // 重新赋值当前正在显示的Fragment
        mcurrentFragment = fragment;
        // 切换显示ø
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }

    public static void GoUserActivity(Context context){
        Intent intent = new Intent(context,UserActivity.class);
        context.startActivity(intent);
    }
}
