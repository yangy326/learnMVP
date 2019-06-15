package cm.example.factory.presenter.account.login;

import android.content.Context;

import com.example.base.mvp.BaseContract;

import cm.example.factory.model.db.User;
import cm.example.factory.presenter.account.register.RegisterContract;

public interface LoginContract {
    interface View extends BaseContract.View<Presenter>{
        void LoginSuccess();
        Context getcontext();
    }
    interface Presenter extends BaseContract.Presenter{
        void Login(String phone, String password);
    }
}
