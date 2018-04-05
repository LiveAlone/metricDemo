package org.yqj.metric.demo.controller.metered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.metered.TimerService;

//@Controller
public class TimerController {

    @Autowired
    private TimerService timerService;

    @RequestMapping(value = "/timer_request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String timerRequest(){
        timerService.timerRequest();
        return "timerRequest";
    }

}
