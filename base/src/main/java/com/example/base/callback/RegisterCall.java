package com.example.base.callback;

public interface RegisterCall<T> {
    void successRegister(T t);
    void failedRegister(T t);
}
