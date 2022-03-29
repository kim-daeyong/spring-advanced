package com.example.spring.advanced.app.v5;

import com.example.spring.advanced.trace.callback.TraceCallback;
import com.example.spring.advanced.trace.callback.TraceTemplate;
import com.example.spring.advanced.trace.logtrace.LogTrace;
import com.example.spring.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.excute("OrderController.request()", () -> {
                orderService.orderItem(itemId);
                return "Ok";
        });

//        return template.excute("OrderController.request()", new TraceCallback<>() {
//            @Override
//            public String call() {
//                orderService.orderItem(itemId);
//                return "Ok";
//            }
//        });
        
//        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
//            @Override
//            protected String call() {
//                orderService.orderItem(itemId);
//                return "Ok";
//            }
//        };
//        return template.excute("OrderController.request()");
    }
}
