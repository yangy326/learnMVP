package com.example.base.base;

import android.content.Context;
import android.util.Log;

import com.example.base.mvp.BaseContract;

public  abstract class PresenterFragment<Presenter extends BaseContract.Presenter> extends BaseFragment implements BaseContract.View<Presenter> {

    protected Presenter mpresenter;

    protected abstract Presenter initPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        initPresenter();
    }

    @Override
    public void showLoading() {
        Log.d("asfsdfsa","showLoading");

    }

    @Override
    public void showError(int code) {


    }

    @Override
    public void setPresenter(Presenter presenter) {
        mpresenter = presenter ;

    }
}
