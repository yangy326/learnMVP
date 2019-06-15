package cm.example.factory.presenter.account.register;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.base.callback.RegisterCall;
import com.example.base.data.DataSource;
import com.example.base.mvp.BasePresenter;

import cm.example.factory.helper.AccountHelper;
import cm.example.factory.model.register.RegisterModel;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter, RegisterCall {


    public RegisterPresenter(RegisterContract.View mview) {
        super(mview);
    }

    @Override
    public void register(String phone, String name ,String password) {
        //start();
        if (phone.isEmpty() || name.isEmpty() || password.isEmpty()){
            mview.showError(100);
        } else if (phone.length() != 11) {
            mview.showError(101);
        }
        else if (password.length() <= 6){
            mview.showError(102);
        }
        else {
            RegisterModel model = new RegisterModel(phone,name,password);

            AccountHelper.register(model,this);


        }



    }

    @Override
    public void successRegister(Object o) {
        mview.registerSuccess();
    }

    @Override
    public void failedRegister(Object o) {
        ((Activity)mview.getcontext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mview.getcontext(), "注册失败", Toast.LENGTH_SHORT).show();
            }
        });
    }








}


