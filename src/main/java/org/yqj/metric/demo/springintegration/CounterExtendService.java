package org.yqj.metric.demo.springintegration;

import com.ryantenney.metrics.spring.CountedExtend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author yaoqijun on 2018-04-08.
 */
//@Service
@Slf4j
public class CounterExtendService {

    private LongAdder longAdder = new LongAdder();

    @CountedExtend(name = "local.method.counterExtend.request", absolute = true, monotonic = true)
    public void counterAddRequest(){
        longAdder.increment();
        log.info("current total request long adder is :{}", longAdder.sum());
    }
}
