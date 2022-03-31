package com.example.spring.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("exception");
        }
        sleep(1000);
    }

    private void sleep(int miliis) {
        try {
            Thread.sleep(miliis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
