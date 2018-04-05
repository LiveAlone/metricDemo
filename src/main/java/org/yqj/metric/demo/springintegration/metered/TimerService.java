package org.yqj.metric.demo.springintegration.metered;

import com.codahale.metrics.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

//@Service
@Slf4j
public class TimerService {

    @Timed(name = "method.name.timer.request", absolute = true)
    public void timerRequest(){
        // sleep random time
        long sleepTime = ThreadLocalRandom.current().nextLong(5000L);
        try {
            log.info("current thread is to sleep time {}", sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
