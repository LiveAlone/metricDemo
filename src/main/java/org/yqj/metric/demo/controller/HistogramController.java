package org.yqj.metric.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.HistogramService;

//@Controller
public class HistogramController {

    @Autowired
    private HistogramService histogramService;

    @RequestMapping(value = "/histogram_request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String histogramRequest(){
        histogramService.histogramRequest();
        return "histogramRequest";
    }

}
