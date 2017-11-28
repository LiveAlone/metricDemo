package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-06.
 */
public class CounterTest {

    public static void addCounter(MetricRegistry metricRegistry){
        Counter counter = metricRegistry.counter("counterTest");

        new Thread(()->{
            while (true) {
                int value = ThreadLocalRandom.current().nextInt(1000);
                System.out.println("counter random value "+value);
                counter.inc(value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
