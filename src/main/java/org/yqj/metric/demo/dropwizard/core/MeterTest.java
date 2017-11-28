package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class MeterTest {

    public static void addMeter(MetricRegistry metricRegistry){

        Meter requests = metricRegistry.meter("MeterTest");

        new Thread(() -> {
            while (true){
                int randomValue = ThreadLocalRandom.current().nextInt(10);
//                System.out.println("meter random value " + randomValue);
                requests.mark(randomValue);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
