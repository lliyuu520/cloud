package com.liliangyu.springcloud.eurekaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliangyu
 * @description clientController
 * @date 2018/7/31
 */
@RestController
public class ConsumerController {
    /**
     * logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    private Environment environment;

    @Autowired
    public ConsumerController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/eurekaConsumer")
    public String getOne() {
        String property = environment.getProperty("server.port");
        LOGGER.info("port:" + property);
        return "eurekaConsumer";
    }
}