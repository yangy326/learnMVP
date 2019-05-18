package com.example.base.mvp;





public class BasePresenter<M extends IModel, V extends BaseView> implements IPresenter {
    protected final String TAG = this.getClass().getSimpleName();
//    protected CompositeSubscription mCompositeSubscription;

    protected M mModel;
    protected V mView;



    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }


    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mView = null;
    }



}
