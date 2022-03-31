package com.example.spring.advanced.trace.hellotrace;

import com.example.spring.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void begin() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("test");
    }

    @Test
    void end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("test");
        trace.end(status);
    }

    @Test
    void exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("test");
        trace.exception(status, new IllegalArgumentException());
    }
}