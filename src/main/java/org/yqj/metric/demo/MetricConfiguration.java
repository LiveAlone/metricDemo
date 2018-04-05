package org.yqj.metric.demo;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.log4j2.InstrumentedAppender;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by yaoqijun on 2017-09-04.
 */
@Configuration
@EnableMetrics
public class MetricConfiguration extends MetricsConfigurerAdapter {

    private final static MetricRegistry metricRegistry = SharedMetricRegistries.getOrCreate("log4j2Metrics");
    private final static InstrumentedAppender appender = InstrumentedAppender.createAppender("log", "log4j2Metrics");

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        registerReporter(ConsoleReporter.forRegistry(metricRegistry).build())
                .start(10, TimeUnit.SECONDS);
    }

    @Override
    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
}
