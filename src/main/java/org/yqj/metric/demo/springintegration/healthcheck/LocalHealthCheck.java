package org.yqj.metric.demo.springintegration.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class LocalHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        long value = ThreadLocalRandom.current().nextLong(1000L);
        log.info("health check current is {}", value);
        if (value % 2 == 0){
            return Result.healthy("rand result is health");
        }else {
            return Result.unhealthy("rand is not health current", new IllegalStateException("illegal state value " + value));
        }
    }
}
