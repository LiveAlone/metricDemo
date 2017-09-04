package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class MetersTest {

    private static final MetricRegistry metricRegistry = new MetricRegistry();

    private static final List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);

//    public static void main(String[] args) throws Exception {

//        startReport();

//        Meter requests = metricRegistry.meter("requests");

        // meters
//        requests.mark(10);

        // 这种调用方式 size() 会有消耗
//        registerGauges("jobs");

        // counters config
//        Counter counter = metricRegistry.counter(MetricRegistry.name(MetersTest.class, "preding-jobs"));
//        for (int i=0; i<10; i++) {
//            counter.inc();
//        }

        // Histograms 历史数据统计的方式
//        Histogram histogram = metricRegistry.histogram(MetricRegistry.name(MetersTest.class, "response-sizes"));
//        for (int i=0; i<10; i++){
//            histogram.update(i);
//        }

        // Timer 的统计配置方式
//        Timer timer = metricRegistry.timer(MetricRegistry.name(MetersTest.class, "responses"));
//        for (int i=0; i<10; i++){
//            Context context = timer.time();
//
//            long wait = ThreadLocalRandom.current().nextLong(10);
//            Thread.sleep(wait * 1000);
//
//            context.stop();
//        }
//        System.out.println("all over");


        // jmx repository
//        JmxReporter reporter = JmxReporter.forRegistry(metricRegistry).build();
//        reporter.start();

//        waitSeconds();
//    }

    // metric queue size content
    private static void registerGauges(String name){
        metricRegistry.register(MetricRegistry.name(MetersTest.class, name, "size"), new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return list.size();
            }
        });
    }

    private static void startReport(){
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        reporter.start(1, TimeUnit.SECONDS);
    }

    private static void waitSeconds(){
        try {
            Thread.sleep(5 * 1000);
        } catch (Exception e){

        }
    }
}
