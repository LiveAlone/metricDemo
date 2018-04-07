package org.yqj.metric.demo.controller;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.health.SharedHealthCheckRegistries;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HealthCheckController {

    @Autowired
    private HealthCheckRegistry healthCheckRegistry;

    @RequestMapping(value = "/health_info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String healthCheckInfo(){
        healthCheckRegistry.runHealthChecks().forEach((k, v)-> log.info("***************** health info key:{}, value:{}, message:{}", k, v.isHealthy(), v.getMessage()));
        return "healthCheckInfo";
    }

    @RequestMapping(value = "/shared_health_info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String healthCheckSharedInfo(){
        for (String s : SharedHealthCheckRegistries.names()) {
            log.info("shared heath check info :{}", s);
        }
        return "sharedHealthInfo";
    }

}
