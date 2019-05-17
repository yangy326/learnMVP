package com.example.base.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.example.base.mvp.IPresenter;

public abstract class BaseActivity<P extends IPresenter>extends AppCompatActivity {

    protected Application mApplication;

    protected P mPresenter;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(initRootView());
        initView();

        initData();


        initListener();
    }

    public void fullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        this.mApplication = null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    protected abstract View initRootView();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();


}
