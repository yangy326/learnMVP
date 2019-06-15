package com.example.yangyang.learnmvp.fragment.user;


import android.app.Activity;
import android.content.Context;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.base.BaseFragment;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.activity.MainActivity;
import com.example.yangyang.learnmvp.R;

import cm.example.factory.presenter.account.login.LoginContract;
import cm.example.factory.presenter.account.login.LoginPresnter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener {

    private Context mContext;
    private LoginPresnter mPresenter;

    private UserTrigger userTrigger;

    private EditText phone,  password;

    private Button submit;

    private TextView textView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        userTrigger = (UserTrigger) context;
        initPresenter();

    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        submit = root.findViewById(R.id.btn_login);
        phone = root.findViewById(R.id.edit_account_login);
        textView = root.findViewById(R.id.txt_login_goRegister);
        password = root.findViewById(R.id.edit_password_login);
        submit.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void LoginSuccess() {
        MainActivity.GoMainActivity(mRoot.getContext());
        ((Activity)mContext).finish();

    }

    protected LoginPresnter initPresenter() {
        return  new LoginPresnter(this);

    }
    @Override
    public Context getcontext() {
        return mContext;
    }



    @Override
    public void showLoading() {
        Toast.makeText(mContext, "loading", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showError(int code) {
        Common.decodeFailedCode(mContext,code);

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = (LoginPresnter) presenter;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:

                mPresenter.Login(phone.getText().toString(),password.getText().toString());
                break;
            case R.id.txt_login_goRegister:
                userTrigger.triggerView();

                break;

        }

    }
}
