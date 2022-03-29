package com.example.spring.advanced.strategy;

import com.example.spring.advanced.strategy.code.template.Callback;
import com.example.spring.advanced.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(new Callback() {
            @Override
            public void call() {
                log.info("logic 1");
            }
        });

        template.excute(new Callback() {
            @Override
            public void call() {
                log.info("logic 2");
            }
        });
    }

    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(() -> log.info("logic 1"));
        template.excute(() -> log.info("logic 2"));
    }
}
