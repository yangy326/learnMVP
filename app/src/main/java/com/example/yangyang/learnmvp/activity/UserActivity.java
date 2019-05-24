package com.example.yangyang.learnmvp.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.fragment.user.LoginFragment;
import com.example.yangyang.learnmvp.fragment.user.RegisterFragment;
import com.example.yangyang.learnmvp.fragment.user.UserTrigger;

public class UserActivity extends BaseActivity implements UserTrigger{

    private BaseFragment mcurrentFragment , loginFragment , registerFragment;





    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initWindows() {
        super.initWindows();

        mcurrentFragment = loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mcurrentFragment)
                .commit();
    }

    @Override
    public void triggerView() {

        BaseFragment fragment;
        if (mcurrentFragment == loginFragment) {
            if (registerFragment == null) {
                //默认情况下为null，
                //第一次之后就不为null了
                registerFragment = new RegisterFragment();
            }
            fragment = registerFragment;
        } else {
            // 因为默认请求下mLoginFragment已经赋值，无须判断null
            fragment = loginFragment;
        }

        // 重新赋值当前正在显示的Fragment
        mcurrentFragment = fragment;
        // 切换显示ø
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }
}
