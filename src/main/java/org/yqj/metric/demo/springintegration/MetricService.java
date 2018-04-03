package org.yqj.metric.demo.springintegration;

import com.codahale.metrics.annotation.Metric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yqj.metric.demo.springintegration.bean.SimpleLongGauge;

/**
 * @author yaoqijun on 2018-04-03.
 */
@Service
@Slf4j
public class MetricService {

    @Metric(name = "field.name.metric.count", absolute = true)
    @Autowired
    private SimpleLongGauge simpleLongGauge;

    public void configAddMetric(long value){
        simpleLongGauge.setValue(value);
    }
}
