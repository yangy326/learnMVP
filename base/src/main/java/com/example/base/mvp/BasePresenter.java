package com.example.base.mvp;





public class BasePresenter< M extends BaseContract.View> implements BaseContract.Presenter{

    protected M mview;

    public BasePresenter(M mview) {
        this.mview = mview;
        this.mview.setPresenter(this);
    }

    protected M getMview() {
        return mview;
    }

    @Override
    public void start() {
        if (mview != null){
            mview.showLoading();
        }

    }

    @Override
    public void destory() {
        if (mview != null){
            mview.setPresenter(null);
            mview = null;
        }

    }
}
