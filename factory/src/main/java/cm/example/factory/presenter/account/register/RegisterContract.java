package cm.example.factory.presenter.account.register;

import android.content.Context;

import com.example.base.mvp.BaseContract;

public interface RegisterContract {

    interface View extends BaseContract.View<Presenter>{
        void registerSuccess();
        Context getcontext();
    }
    interface Presenter extends BaseContract.Presenter{
        void register(String phone, String name ,String password);
    }

}
