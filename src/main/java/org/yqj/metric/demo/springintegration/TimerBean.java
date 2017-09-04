package org.yqj.metric.demo.springintegration;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-04.
 */
@Component
public class TimerBean {

    private static final Logger logger = LoggerFactory.getLogger(TimerBean.class);

    @Timed
    public void consume(){
        long seconds = ThreadLocalRandom.current().nextLong(20);
        logger.info("start consume, seconds:{}", seconds);
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("finish consume");
    }
}
