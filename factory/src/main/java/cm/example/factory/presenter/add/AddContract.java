package cm.example.factory.presenter.add;

import android.content.Context;

import com.example.base.mvp.BaseContract;

import java.util.List;

import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;
import cm.example.factory.presenter.search.SearchContract;

public interface AddContract {
    interface View extends BaseContract.View<Presenter>{

        void addSusscess(User user);

        void getSusscess(UserCard user);

        Context getcontext();
    }

    interface Presenter extends BaseContract.Presenter{
        void add(int originId , int targetId);
        void getUserInfo(int userId);
    }
}
