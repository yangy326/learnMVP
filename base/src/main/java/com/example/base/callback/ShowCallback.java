package com.example.base.callback;

import java.util.List;

public interface ShowCallback {
    interface ShowPerson<T>{
        void success(List<T> t);
        void failed(T t);
    }
    interface ShowGroup<T>{
        void success(T t);
        void failed(T t);
    }
}
