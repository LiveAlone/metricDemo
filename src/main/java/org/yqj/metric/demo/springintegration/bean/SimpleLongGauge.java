package org.yqj.metric.demo.springintegration.bean;

import com.codahale.metrics.Gauge;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-03.
 */
@Component
public class SimpleLongGauge implements Gauge<Long> {
    private volatile long value;

    public SimpleLongGauge() {
        this.value = 0;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return value;
    }
}
