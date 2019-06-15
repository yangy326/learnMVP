package com.example.base.data;

public interface DataSource {
    interface CallBack<T> extends SuccessBack<T>,FailedBack<T>{

    }




        interface SuccessBack<T >{
            void successDataLoaded(T t);
        }

        interface FailedBack<T>{
            void failedDataLoaded(T t);
        }



}
