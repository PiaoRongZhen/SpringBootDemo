package com.example.demo;

import cn.hutool.cron.CronUtil;
import com.example.demo.cron.DemoTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        CronUtil.schedule("*/1 * * * *", new DemoTask());
        CronUtil.start();
    }

}
