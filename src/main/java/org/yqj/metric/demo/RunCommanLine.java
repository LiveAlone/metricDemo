package org.yqj.metric.demo;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.metric.demo.springintegration.TimerBean;


/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommanLine implements CommandLineRunner{

    @Autowired
    private TimerBean timerBean;

    public void run(String... args) throws Exception {
        log.info(" command info run");
        System.out.println("now command line run ");
        System.out.println("args content is " + Lists.newArrayList(args).toString());

        for (int i=0; i<50; i++){
            timerBean.consume();
        }

        System.out.println("finish consume");
    }
}
