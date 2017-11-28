package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-06.
 * 结合Meter Histogram 的配置
 */
public class TimeTest {

    public static void timeTest(MetricRegistry metricRegistry){

        Timer timer = metricRegistry.timer("timer");

        new Thread(() -> {
            while (true){
                Context context = timer.time();
                try {
                    long randomValue = ThreadLocalRandom.current().nextLong(2000);
                    Thread.sleep(randomValue);
                }catch (Exception e){
                    e.printStackTrace();
                }
                context.stop();
            }
        }).start();
    }
}
