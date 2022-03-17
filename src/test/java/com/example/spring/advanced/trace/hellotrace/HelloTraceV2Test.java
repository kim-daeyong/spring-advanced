package com.example.spring.advanced.trace.hellotrace;

import com.example.spring.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void begin() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("test");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "test2");
    }

    @Test
    void end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("test");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "test2");
        trace.end(status2);
    }

    @Test
    void exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("test");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "test2");
        trace.exception(status2, new IllegalArgumentException());
    }
}