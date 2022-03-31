package com.example.spring.advanced.strategy.code.template;

import com.example.spring.advanced.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void excute(Callback callback) {
        long startTime = System.currentTimeMillis();
        //비즈니스로직 실행
        callback.call();
        //비즈니스로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
