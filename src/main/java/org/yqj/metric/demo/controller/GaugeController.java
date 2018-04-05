package org.yqj.metric.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.GaugeService;

/**
 * @author yaoqijun on 2018-04-03.
 */
//@Controller
public class GaugeController {

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(value = "/gauge_add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void gaugeAddCount(){
        gaugeService.addCount();
    }

}
