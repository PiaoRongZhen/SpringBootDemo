package com.example.demo.liteflow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("a")
@Slf4j
public class ASwitchComponent extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        log.info(this.getRequestData());
        OrderContext orderContext = this.getContextBean(OrderContext.class);
        UserContext userContext = this.getContextBean(UserContext.class);
        log.info(orderContext.getOrder());
        log.info(userContext.getUser());
        orderContext.setOrder("new order");
        userContext.setUser("new user");
        return "c";
    }
}
