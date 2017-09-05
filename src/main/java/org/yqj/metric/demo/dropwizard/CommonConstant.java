package org.yqj.metric.demo.dropwizard;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class CommonConstant {

    public static void ConsoleReport(MetricRegistry metricRegistry){
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        reporter.start(3, TimeUnit.SECONDS);
    }

    public static void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e){

        }
    }

}
