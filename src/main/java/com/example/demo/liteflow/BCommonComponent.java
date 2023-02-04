package com.example.demo.liteflow;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("b")
@Slf4j
public class BCommonComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        // do your business
        log.info("B CommonComponent");
    }
}
