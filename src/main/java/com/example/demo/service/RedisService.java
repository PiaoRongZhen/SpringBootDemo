package com.example.demo.service;

import com.baomidou.lock.annotation.Lock4j;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author piaorongzhen
 */
@Service
public class RedisService {

    @Lock4j(keys = {"#user.name"}, expire = 60000, acquireTimeout = 1000)
    public void lock(User user) {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
