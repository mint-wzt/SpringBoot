package com.wzt.practise.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}
