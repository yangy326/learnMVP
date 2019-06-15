package cm.example.factory.presenter.showfriend;

import com.example.base.callback.ShowCallback;
import com.example.base.mvp.BasePresenter;

import java.util.List;

import cm.example.factory.helper.AccountHelper;

public class ShowPresenter extends BasePresenter<ShowContract.View> implements ShowContract.Presenter
,ShowCallback.ShowPerson{
    public ShowPresenter(ShowContract.View mview) {
        super(mview);
    }

    @Override
    public void searchFriend(int userId) {
        AccountHelper.getFriend(userId,mview.getcontext(),this);

    }

    @Override
    public void searchGroup(int userId) {

    }

    @Override
    public void success(List t) {
        mview.showFriendSusscess(t);

    }

    @Override
    public void failed(Object o) {

    }
}
