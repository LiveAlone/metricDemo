package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import org.yqj.metric.demo.dropwizard.CommonConstant;

/**
 * Created by yaoqijun on 2017/9/6.
 */
public class TimerTest {

    public static void main(String[] args) throws Exception{
        MetricRegistry metricRegistry  = new MetricRegistry();

        CommonConstant.ConsoleReport(metricRegistry);

//         Timer 的统计配置方式
        Timer timer = metricRegistry.timer(MetricRegistry.name(MetersTest.class, "responses"));
        for (int i=0; i<10; i++){
            Context context = timer.time();
            Thread.sleep(10 * 1000);
            context.stop();
        }

        CommonConstant.waitSeconds(600);
    }

}
