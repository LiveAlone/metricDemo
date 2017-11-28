package org.yqj.metric.demo.dropwizard;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import org.yqj.metric.demo.dropwizard.core.GaugeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class CommonConstant {

    public static void main(String[] args) {
        MetricRegistry metricRegistry = new MetricRegistry();

        CommonConstant.ConsoleReport(metricRegistry);

//        CounterTest.addCounter(metricRegistry);

//        MeterTest.addMeter(metricRegistry);

//        TimeTest.timeTest(metricRegistry);

//        HistogramTest.histogramAdd(metricRegistry);

        GaugeTest.gaugeAdd(metricRegistry);

        CommonConstant.waitSeconds(60);
    }

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
