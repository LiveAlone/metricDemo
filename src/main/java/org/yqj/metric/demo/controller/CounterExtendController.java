package org.yqj.metric.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.CounterExtendService;

/**
 * @author yaoqijun on 2018-04-08.
 */
//@Controller
public class CounterExtendController {

    @Autowired
    private CounterExtendService counterExtendService;

    @RequestMapping(value = "/counter_extend_request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String countRequest(){
        counterExtendService.counterAddRequest();
        return "counterExtendRequest";
    }
}
