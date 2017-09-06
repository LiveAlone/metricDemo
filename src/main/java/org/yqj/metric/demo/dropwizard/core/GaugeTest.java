package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-06.
 * 监听事件的变化
 */
public class GaugeTest {
    public static void gaugeAdd(MetricRegistry metricRegistry) {
        metricRegistry.register("gaugeTest", new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return ThreadLocalRandom.current().nextInt(100);
            }
        });
    }
}
