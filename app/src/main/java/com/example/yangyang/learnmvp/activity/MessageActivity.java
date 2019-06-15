package com.example.yangyang.learnmvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.fragment.message.ChatGroupFragment;
import com.example.yangyang.learnmvp.fragment.message.ChatUserFragment;

import java.io.Serializable;

import cm.example.factory.model.db.BaseFriend;
import cm.example.factory.model.user.UserCard;

public class MessageActivity extends BaseActivity {

    private static boolean isPerson ;

    private BaseFriend target;





    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected boolean initArgs(Bundle bundle) {
        target =  (BaseFriend) bundle.getSerializable("target");
        isPerson = bundle.getBoolean("isPerson");


        return super.initArgs(bundle);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        BaseFragment fragment;
        if (isPerson)
            fragment = new ChatUserFragment();
        else
            fragment = new ChatGroupFragment();

        // 从Activity传递参数到Fragment中去
        Bundle bundle = new Bundle();
        bundle.putSerializable("target", target);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    public static void GotoMessageActivity(Context context, BaseFriend baseFriend, boolean isPerson){
        Intent intent = new Intent(context,MessageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("target",baseFriend);
        bundle.putBoolean("isPerson",isPerson);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
