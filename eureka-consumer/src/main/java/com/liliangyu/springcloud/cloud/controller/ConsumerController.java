package com.liliangyu.springcloud.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    private final LocalDateTime datetime = LocalDateTime.now();

    /**
     * @return
     */
    @GetMapping("/eurekaConsumer")
    public String getOne() {
        LOGGER.info("eurekaConsumer" + datetime);
        return "eurekaConsumer";
    }
}
