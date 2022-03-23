package com.example.spring.advanced.app.v4;

import com.example.spring.advanced.template.AbstractTemplate;
import com.example.spring.advanced.trace.TraceStatus;
import com.example.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalArgumentException("exception");
                }
                sleep(1000);
                return null;
            }
        };
        template.excute("OrderRepository.save()");
    }

    private void sleep(int miliis) {
        try {
            Thread.sleep(miliis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
