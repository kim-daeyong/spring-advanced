package com.example.spring.advanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}