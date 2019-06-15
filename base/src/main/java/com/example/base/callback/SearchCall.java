package com.example.base.callback;

import java.util.List;

public interface SearchCall<T> {
    void successSearch(List<T> t);
    void failedSearch(List<T> t);
}
