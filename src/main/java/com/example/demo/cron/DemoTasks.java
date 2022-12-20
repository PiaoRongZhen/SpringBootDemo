package com.example.demo.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class DemoTasks {

    public void task1() {
        log.info("task1 start: current DateTime, {}", LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("task1 end: current DateTime, {}", LocalDateTime.now());
    }

    public void task2() {
        log.info("task2 start: current DateTime, {}", LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("task2 end: current DateTime, {}", LocalDateTime.now());
    }
}
