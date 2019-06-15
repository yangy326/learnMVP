package cm.example.factory.presenter.showfriend;

import android.content.Context;

import com.example.base.mvp.BaseContract;

import java.util.List;

import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;
import cm.example.factory.presenter.search.SearchContract;

public interface ShowContract {
    interface View extends BaseContract.View<Presenter>{

        void showFriendSusscess(List<UserCard> card);

        void showGroupSusscess(UserCard card);

        Context getcontext();
    }

    interface Presenter extends BaseContract.Presenter{
        void searchFriend(int userId);
        void searchGroup(int userId);
    }
}
