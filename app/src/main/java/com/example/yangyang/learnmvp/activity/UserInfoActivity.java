package com.example.yangyang.learnmvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.R;

import java.util.List;

import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;
import cm.example.factory.presenter.add.AddContract;
import cm.example.factory.presenter.add.AddPresenter;
import cm.example.factory.presenter.search.SearchPresenter;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener,AddContract.View {
    private static int userId ;

    private TextView userName , phone , sex;

    private Button add ;

    private AddPresenter mPresenter;
    protected AddPresenter initPresenter() {
        return  new AddPresenter(this);

    }



    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected boolean initArgs(Bundle bundle) {
        userId = bundle.getInt("userId");
        return super.initArgs(bundle);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initPresenter();
        userName = (TextView)findViewById(R.id.txt_name);
        phone = (TextView)findViewById(R.id.txt_phone);
        sex = (TextView)findViewById(R.id.txt_sex);
        add = (Button)findViewById(R.id.btn_add);
        add.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getUserInfo(userId);
    }

    public static void GoUserInfoActivity(Context context,int userId){
        Intent intent = new Intent(context,UserInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("userId",userId);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                mPresenter.add(Common.getUserId(v.getContext()),userId);

        }
    }



    @Override
    public void addSusscess(User user) {
        add.setText("发消息");

    }


    @Override
    public void getSusscess(UserCard user) {
        phone.setText("手机:" + user.getUserAccount());
        userName.setText(user.getUserName());
        if (user.getUserSex() == 2) sex.setText("性别:女");
        else sex.setText("性别:男");
        if (user.getIsFollow() == 2) add.setText("发消息");



    }

    @Override
    public Context getcontext() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void setPresenter(AddContract.Presenter presenter) {
        mPresenter = (AddPresenter) presenter;

    }
}
