package cm.example.factory.presenter.add;

import com.example.base.callback.AddrCall;
import com.example.base.mvp.BasePresenter;

import cm.example.factory.helper.AccountHelper;
import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;

public class AddPresenter extends BasePresenter<AddContract.View> implements
        AddContract.Presenter,
        AddrCall.GetCallback,
        AddrCall.AddCallback {
    public AddPresenter(AddContract.View mview) {
        super(mview);
    }

    @Override
    public void add(int originId , int targetId) {
        AccountHelper.add(originId,targetId,mview.getcontext(),this);

    }

    @Override
    public void getUserInfo(int userId) {
        AccountHelper.getUserInfo(userId,mview.getcontext(),this);
    }



    @Override
    public void successAdd(Object o) {
        mview.addSusscess((User)o);



    }

    @Override
    public void failedAdd(Object o) {

    }

    @Override
    public void successGet(Object o) {
        mview.getSusscess((UserCard)o);
    }

    @Override
    public void failedGet(Object o) {

    }
}
