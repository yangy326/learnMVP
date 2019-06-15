package com.example.yangyang.learnmvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.fragment.search.AddGroupFragment;
import com.example.yangyang.learnmvp.fragment.search.AddPersonFragment;
import com.example.yangyang.learnmvp.fragment.user.LoginFragment;
import com.example.yangyang.learnmvp.fragment.user.RegisterFragment;
import com.example.yangyang.learnmvp.fragment.user.UserTrigger;

public class SearchActivity extends BaseActivity implements UserTrigger, View.OnClickListener {
    private BaseFragment mcurrentFragment ,addPersonFragment , addGroupFragment;

    private TextView person,group;

    private UserTrigger userTrigger = (UserTrigger)this;

    private TextView current  ;



    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initWindows() {
        super.initWindows();
        mcurrentFragment = addPersonFragment = new AddPersonFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mcurrentFragment)
                .commit();
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        person = (TextView)findViewById(R.id.txt_person);
        current = person;
        group = (TextView)findViewById(R.id.txt_group);
        person.setOnClickListener(this);
        group.setOnClickListener(this);
    }

    @Override
    public void triggerView() {

        BaseFragment fragment;

        if (mcurrentFragment == addPersonFragment) {
            if (addGroupFragment == null) {
                //默认情况下为null，
                //第一次之后就不为null了
                addGroupFragment = new AddGroupFragment();
            }
            fragment = addGroupFragment;
        } else {
            // 因为默认请求下mLoginFragment已经赋值，无须判断null
            fragment = addPersonFragment;
        }

        // 重新赋值当前正在显示的Fragment
        mcurrentFragment = fragment;
        // 切换显示ø
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }

    public static void GoSearchActivity(Context context){
        Intent intent = new Intent(context,SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_person:
                textTrigger(person);
               // RealSearchActivity.GoRealSearchActivity(v.getContext(),1);



                break;
            case R.id.txt_group:
                textTrigger(group);
               // RealSearchActivity.GoRealSearchActivity(v.getContext(),2);


                break;


        }

    }
    void textTrigger(TextView view){
        if (current != view){
            current.setTextColor(getResources().getColor(R.color.black));
            view.setTextColor(getResources().getColor(R.color.red));
            current = view ;
            userTrigger.triggerView();


        }


    }
}
