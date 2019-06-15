package com.example.base.callback;

public interface AddrCall<T> {
    interface AddCallback<T>{
        void successAdd(T t);
        void failedAdd(T t);
    }
    interface GetCallback<T>{
        void successGet(T t);
        void failedGet(T t);
    }

}
