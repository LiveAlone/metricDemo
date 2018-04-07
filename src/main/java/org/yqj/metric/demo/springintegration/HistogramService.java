package org.yqj.metric.demo.springintegration;

import com.codahale.metrics.Histogram;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

//@Service
@Slf4j
public class HistogramService {

    @Autowired
    @Qualifier("histogramLocalBean")
    private Histogram histogram;

    public void histogramRequest() {
        long value = ThreadLocalRandom.current().nextLong(1000L);
        log.info("current histogram count is {}", value);
        histogram.update(value);
    }
}
