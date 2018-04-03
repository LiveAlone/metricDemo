package org.yqj.metric.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yqj.metric.demo.springintegration.CounterService;

/**
 * @author yaoqijun on 2018-04-03.
 */
@Controller
public class CounterController {

    @Autowired
    private CounterService counterService;

    @RequestMapping(value = "/counter_request", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String countRequest(){
        counterService.counterRequest();
        return "counterRequest";
    }

}
