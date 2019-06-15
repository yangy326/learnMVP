package cm.example.factory.presenter.account.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.base.callback.LoginCall;
import com.example.base.common.Common;
import com.example.base.mvp.BaseContract;
import com.example.base.mvp.BasePresenter;

import cm.example.factory.helper.AccountHelper;
import cm.example.factory.model.db.User;
import cm.example.factory.model.login.LoginModel;

import static android.content.Context.MODE_PRIVATE;

public class LoginPresnter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter,LoginCall<User> {
    public LoginPresnter(LoginContract.View mview) {
        super(mview);
    }

    @Override
    public void Login(String phone, String password) {
        if (phone.isEmpty() ||  password.isEmpty()){
            mview.showError(100);
        } else if (phone.length() != 11) {
            mview.showError(101);
        }
        else if (password.length() <= 6){
            mview.showError(102);
        }
        else {
            LoginModel model = new LoginModel(phone,password,Common.getPushId(mview.getcontext()));
            AccountHelper.login(model,this);
        }




    }

    @Override
    public void successLogin(User user) {

        SharedPreferences.Editor editor= mview.getcontext().getSharedPreferences("Token",MODE_PRIVATE).edit();

        editor.putString("token",user.getUserToken());
        editor.putInt("userId",user.getUserId());

        editor.apply();

        mview.LoginSuccess();


    }

    @Override
    public void failedLogin(User user) {
        ((Activity)mview.getcontext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mview.getcontext(), "登陆失败", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
