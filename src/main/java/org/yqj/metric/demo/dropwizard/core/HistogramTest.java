package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-06.
 */
public class HistogramTest {

    public static void histogramAdd(MetricRegistry metricRegistry){
        Histogram histogram = metricRegistry.histogram("histogramTest");
        new Thread(() -> {
            while (true){
                histogram.update(ThreadLocalRandom.current().nextLong(1000));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
