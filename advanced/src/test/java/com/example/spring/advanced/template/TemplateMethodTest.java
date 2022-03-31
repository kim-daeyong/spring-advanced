package com.example.spring.advanced.template;

import com.example.spring.advanced.template.code.AbstractTemplate;
import com.example.spring.advanced.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스로직 실행
        log.info("비즈니스 로직 실행");
        //비즈니스로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스로직 실행
        log.info("비즈니스 로직 실행");
        //비즈니스로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();

        AbstractTemplate template2 = new SubClassLogic1();
        template2.excute();
    }

    @Test
    void templateMethodV2() { // 익명 내부 클래스
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1");
            }
        };
        log.info("classname = {}", template1.getClass());
        template1.excute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2");
            }
        };
        log.info("classname = {}", template2.getClass());
        template2.excute();
    }
}
