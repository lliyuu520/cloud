package com.liliangyu.springcloud.eurekaconsumer.controller;

import com.liliangyu.springcloud.eurekaconsumer.feign.client.ConsumerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliangyu
 * @description consumerClient
 * @date 2018/7/31
 */
@RestController
public class ConsumerController {
    @Autowired
    ConsumerFeignClient consumerFeignClient;
    /**
     * logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    Environment environment;
@HystrixCommand(fallbackMethod ="back" )
    @GetMapping("feign/hystrix")
    public String getOne() {
        LOGGER.info("environment"+environment.getProperty("server.port"));
        String one = consumerFeignClient.getOne();
        return one;
    }

    public String back(){
        return "back";
    }
}
