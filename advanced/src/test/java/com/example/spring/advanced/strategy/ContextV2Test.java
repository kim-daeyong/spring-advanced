package com.example.spring.advanced.strategy;

import com.example.spring.advanced.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 contextx = new ContextV2();
        contextx.excute(new StrategyLogic1());
        contextx.excute(new StrategyLogic2());
        contextx.excute(() -> log.info("비즈니스 로직 실행"));
    }
}
