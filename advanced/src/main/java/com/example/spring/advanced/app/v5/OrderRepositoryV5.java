package com.example.spring.advanced.app.v5;

import com.example.spring.advanced.trace.callback.TraceTemplate;
import com.example.spring.advanced.trace.logtrace.LogTrace;
import com.example.spring.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {

        template.excute("OrderRepository.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("exception");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int miliis) {
        try {
            Thread.sleep(miliis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
