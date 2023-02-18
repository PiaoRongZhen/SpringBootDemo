package com.example.demo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @SaCheckLogin
    @SaCheckRole("admin")
    @SaCheckPermission(value = {"user.add", "user.update", "user.get"}, mode = SaMode.OR)
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/update")
    public void update(Long id, Integer age) {
        userService.update(id, age);
    }

    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(1);
            return "登录成功";
        }
        return "登录失败";
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}
