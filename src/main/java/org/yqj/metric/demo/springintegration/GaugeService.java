package org.yqj.metric.demo.springintegration;

import com.codahale.metrics.annotation.Gauge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yaoqijun on 2018-04-03.
 */
//@Service
@Slf4j
public class GaugeService {

    private volatile int count = 0;

    public void addCount(){
        log.info("gauge count adder");
        count = count + 1;
    }

    @Gauge(name = "method.name.gauge.count", absolute = true)
    public int getCount(){
        return count;
    }
}
