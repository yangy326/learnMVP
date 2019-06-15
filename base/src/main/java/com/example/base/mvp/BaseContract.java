package com.example.base.mvp;

public interface BaseContract {
    interface View<T extends Presenter>{
        void showLoading();

        void showError(int code);

        void setPresenter(T presenter);




    }

    interface Presenter{

        void start();

        void destory();

    }
}
