package cm.example.factory.presenter.search;

import android.content.Context;

import com.example.base.base.recycler.RecyclerAdapter;
import com.example.base.mvp.BaseContract;

import java.util.List;

import cm.example.factory.model.db.User;

public interface SearchContract {
    interface View extends BaseContract.View<Presenter>{

        void searchSusscess(List<User> user);

        RecyclerAdapter getRecyclerAdapter();

         Context getcontext();
    }

    interface Presenter extends BaseContract.Presenter{
        void search(String phone);
    }
}
