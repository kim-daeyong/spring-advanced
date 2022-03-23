package com.example.spring.advanced.app.v4;

import com.example.spring.advanced.template.AbstractTemplate;
import com.example.spring.advanced.trace.TraceStatus;
import com.example.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.excute("OrderService.orderItem()");
    }
}
