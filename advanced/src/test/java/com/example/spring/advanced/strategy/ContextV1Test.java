package com.example.spring.advanced.strategy;

import com.example.spring.advanced.strategy.code.strategy.ContextV1;
import com.example.spring.advanced.strategy.code.strategy.Strategy;
import com.example.spring.advanced.strategy.code.strategy.StrategyLogic1;
import com.example.spring.advanced.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void contextV0() {
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
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.excute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.excute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        };
        ContextV1 context1 = new ContextV1(strategyLogic);
        context1.excute();
    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        });
        context1.excute();
    }

    @Test
    void strategyV4() {
        ContextV1 contextx = new ContextV1(() -> log.info("비즈니스 로직 실행"));
        contextx.excute();
    }
}
