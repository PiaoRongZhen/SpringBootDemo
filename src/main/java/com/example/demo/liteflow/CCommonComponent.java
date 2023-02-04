package com.example.demo.liteflow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("c")
@Slf4j
public class CCommonComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        OrderContext orderContext = this.getContextBean(OrderContext.class);
        UserContext userContext = this.getContextBean(UserContext.class);
        log.info(orderContext.getOrder());
        log.info(userContext.getUser());
    }
}
