package com.example.yangyang.learnmvp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.fragment.FriendFragment;
import com.example.yangyang.learnmvp.fragment.MyFragment;
import com.example.yangyang.learnmvp.fragment.SearchFragment;
import com.example.yangyang.learnmvp.fragment.VideoFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView my,search,friend,video;

    private FrameLayout container;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        my = (TextView)findViewById(R.id.main_txt_my);
        search = (TextView)findViewById(R.id.main_txt_search);
        friend = (TextView)findViewById(R.id.main_txt_friend);
        video = (TextView)findViewById(R.id.main_txt_video);
        container = (FrameLayout) findViewById(R.id.main_layout_container);
        my.setOnClickListener(this);
        search.setOnClickListener(this);
        friend.setOnClickListener(this);
        video.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        boolean isFirst = true;
        switch (v.getId()){
            case R.id.main_txt_my:


                MyFragment myFragment = new MyFragment();
                topbarClick(my,myFragment);

                break;
            case R.id.main_txt_search:

                SearchFragment searchFragment = new SearchFragment();
                topbarClick(search,searchFragment);
                break;
            case R.id.main_txt_friend:
                FriendFragment friendFragment = new FriendFragment();
                topbarClick(friend,friendFragment);
                break;
            case R.id.main_txt_video :
                VideoFragment videoFragment = new VideoFragment();
                topbarClick(video,videoFragment);
                break;

        }
    }

    public void topbarClick(TextView textView , BaseFragment baseFragment){
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView.setTextSize(24);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout_container,baseFragment)
                .commit();

    }


}

