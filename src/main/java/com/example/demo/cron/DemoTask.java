package com.example.demo.cron;

import cn.hutool.cron.task.Task;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class DemoTask implements Task {
    @Override
    public void execute() {
        log.info("task start: current DateTime, {}", LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("task end: current DateTime, {}", LocalDateTime.now());
    }
}
