package org.yqj.metric.demo.springintegration.metered;

import com.codahale.metrics.annotation.Metered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class MeterService {

    @Metered(name = "method.name.meter.request", absolute = true)
    public void meterRequest(){
        log.info("current meter request request");
    }

}
