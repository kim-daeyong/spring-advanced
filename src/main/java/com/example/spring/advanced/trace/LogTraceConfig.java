package com.example.spring.advanced.trace;

import com.example.spring.advanced.trace.logtrace.FieldLogTrace;
import com.example.spring.advanced.trace.logtrace.LogTrace;
import com.example.spring.advanced.trace.logtrace.ThreadLocalLogTreace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTreace();
    }
}
