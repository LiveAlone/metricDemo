package org.yqj.metric.demo.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yaoqijun on 2017-09-06.
 */
public class HealthCheckTest extends HealthCheck{

    @Override
    protected Result check() throws Exception {
        return ThreadLocalRandom.current().nextBoolean() ? Result.healthy("current health") : Result.unhealthy("not health");
    }

//    public static void main(String[] args) {
//        HealthCheckRegistry registry = new HealthCheckRegistry();
//        registry.register("test1", new HealthCheckTest());
//        registry.register("test2", new HealthCheckTest());
//        while (true) {
//            for (Map.Entry<String, Result> entry : registry.runHealthChecks().entrySet()) {
//                if (entry.getValue().isHealthy()) {
//                    System.out.println(entry.getKey() + ": OK");
//                } else {
//                    System.err.println(entry.getKey() + ": FAIL, error message: " + entry.getValue().getMessage());
//                    final Throwable e = entry.getValue().getError();
//                    if (e != null) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//
//            }
//        }
//    }
}
