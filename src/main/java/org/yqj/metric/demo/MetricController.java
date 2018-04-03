package org.yqj.metric.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.MetricService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yaoqijun on 2018-04-03.
 */
@Controller
public class MetricController {

    @Autowired
    private MetricService metricService;

    @RequestMapping(value = "/metric_random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void fillMetricCount(){
        metricService.configAddMetric(ThreadLocalRandom.current().nextLong(66666L));
    }
}
