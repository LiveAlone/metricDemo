package org.yqj.metric.demo.dropwizard.core;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.yqj.metric.demo.dropwizard.CommonConstant;

/**
 * Created by yaoqijun on 2017-09-04.
 */
public class MeterTest {

    public static void main(String[] args) {
        MetricRegistry metricRegistry = new MetricRegistry();

        CommonConstant.ConsoleReport(metricRegistry);

        Meter requests = metricRegistry.meter("requests");

        // meters
        requests.mark(10);

        CommonConstant.waitSeconds(20);
    }

}
