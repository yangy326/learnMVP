package cm.example.factory.presenter.search;

import com.example.base.callback.SearchCall;
import com.example.base.common.Common;
import com.example.base.mvp.BaseContract;
import com.example.base.mvp.BasePresenter;

import java.util.List;

import cm.example.factory.helper.AccountHelper;
import cm.example.factory.model.db.User;
import cm.example.factory.model.login.LoginModel;
import retrofit2.Call;

public class SearchPresenter extends BasePresenter<SearchContract.View> implements SearchContract.Presenter
,SearchCall<User>{
    private Call call;
    public SearchPresenter(SearchContract.View mview) {
        super(mview);
    }

    @Override
    public void search(String phone) {
        if (call != null || !call.isCanceled()){
            call.cancel();
        }
        call= AccountHelper.search(phone,mview.getcontext(),this);


    }

    @Override
    public void successSearch(List<User> t) {
        mview.searchSusscess(t);
    }

    @Override
    public void failedSearch(List<User> t) {

    }
}
