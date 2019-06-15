package com.example.base.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.base.base.widget.convention.PlaceHolderView;
import com.example.base.mvp.IPresenter;

import java.util.List;

public  abstract class BaseActivity extends AppCompatActivity {

    protected PlaceHolderView mPlaceHolderView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initWindows();
        if (initArgs(getIntent().getExtras())){
            setContentView(getContentLayoutId());
            initWidget();
            initData();
        }
        else {
            Toast.makeText(this, "Bundle传值错误", Toast.LENGTH_SHORT).show();
        }
    }

    public void setPlaceHolderView(PlaceHolderView placeHolderView) {
        this.mPlaceHolderView = placeHolderView;
    }


    protected void initWindows(){

    }
    protected boolean initArgs(Bundle bundle){  // Bundle传值拿参数时可以复写这个函数
        return true;
    }

    protected abstract int getContentLayoutId();

    protected void initWidget(){

    }

    protected void initData(){

    }

    @Override
    public void onBackPressed() {

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null){
            for (Fragment fragment : fragments){
                if (fragment instanceof  BaseFragment){
                    if (((BaseFragment) fragment).onBackPressed()){
                        return;
                    }

                }
            }
        }

        super.onBackPressed();
        finish();
    }
}
