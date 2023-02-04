package com.example.demo.controller;

import com.example.demo.liteflow.OrderContext;
import com.example.demo.liteflow.UserContext;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LiteflowController {

    @Resource
    private FlowExecutor flowExecutor;

    @RequestMapping("/liteflow")
    public String liteflow() {
        OrderContext orderContext = new OrderContext();
        orderContext.setOrder("order");
        UserContext userContext = new UserContext();
        userContext.setUser("user");
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "RequestData", orderContext, userContext);
        return String.valueOf(response.isSuccess());
    }
}
