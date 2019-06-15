package com.example.base.callback;

public interface LoginCall<T> {
    void successLogin(T t);
    void failedLogin(T t);
}
