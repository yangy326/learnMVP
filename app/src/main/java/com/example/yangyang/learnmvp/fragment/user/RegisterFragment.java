package com.example.yangyang.learnmvp.fragment.user;


import android.content.Context;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.base.BaseFragment;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.R;

import cm.example.factory.presenter.account.register.RegisterContract;
import cm.example.factory.presenter.account.register.RegisterPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment implements RegisterContract.View, View.OnClickListener {

    private Context mContext;

    private RegisterPresenter mPresenter;

    private UserTrigger userTrigger;

    private EditText phone, name , password;

    private TextView textView;



    private Button submit;

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        submit = root.findViewById(R.id.btn_register);
        phone = root.findViewById(R.id.edit_account);
        name = root.findViewById(R.id.edit_name);
        password = root.findViewById(R.id.edit_password);
        textView = root.findViewById(R.id.txt_register_goLogin);
        submit.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    protected RegisterPresenter initPresenter() {
        return  new RegisterPresenter(this);

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        mContext = context;
        userTrigger = (UserTrigger) context;
        initPresenter();


    }




    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void registerSuccess() {
        userTrigger.triggerView();

    }

    @Override
    public Context getcontext() {
        return mRoot.getContext();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:

                mPresenter.register(phone.getText().toString(),name.getText().toString(),password.getText().toString());

                break;
            case R.id.txt_register_goLogin:
                userTrigger.triggerView();

                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int code) {
        Common.decodeFailedCode(mContext,code);

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = (RegisterPresenter)presenter;

    }

}
