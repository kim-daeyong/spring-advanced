package com.example.spring.advanced.trace.logtrace;

import com.example.spring.advanced.trace.TraceStatus;
import com.example.spring.advanced.trace.hellotrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

public class FliedLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("test1");
        TraceStatus status2 = trace.begin("test2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status = trace.begin("test");
        TraceStatus status2 = trace.begin("test2");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status, new IllegalArgumentException());

    }
}
