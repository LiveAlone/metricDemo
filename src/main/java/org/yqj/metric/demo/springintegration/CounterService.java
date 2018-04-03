package org.yqj.metric.demo.springintegration;

import com.codahale.metrics.annotation.Counted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yaoqijun on 2018-04-03.
 */
@Service
@Slf4j
public class CounterService {

    @Counted(name = "method.name.counter.request", absolute = true, monotonic = true)
    public void counterRequest(){
        log.info("found counter request receiver");
    }

}
