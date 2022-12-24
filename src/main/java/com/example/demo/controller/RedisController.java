package com.example.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.example.demo.domain.User;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author piaorongzhen
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/lock")
    public String lock() {
        String key = IdUtil.simpleUUID();
        User user = new User();
        user.setName(key);
        redisService.lock(user);
        return key;
    }

}
