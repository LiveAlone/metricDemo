package org.yqj.metric.demo.controller.metered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.metered.MeterService;

//@Controller
public class MeterController {

    @Autowired
    private MeterService meterService;

    @RequestMapping(value = "/meter_request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String meterRequest(){
        meterService.meterRequest();
        return "meterRequest";
    }

}
