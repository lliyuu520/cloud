package com.liliangyu.springcloud.cloud.controller;

import com.liliangyu.springcloud.cloud.feign.client.ConsumerZipkinFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliangyu
 * @description consumerClient
 * @date 2018/7/31
 */
@RestController
public class ConsumerController {
    /**
     * logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerZipkinController.class);
    private ConsumerZipkinFeignClient consumerFeignClient;

    @Autowired
    public ConsumerController(ConsumerZipkinFeignClient consumerFeignClient) {
        this.consumerFeignClient = consumerFeignClient;
    }

    @GetMapping("feign")
    public String getOne() {
        String one = consumerFeignClient.getOne();
        return one;
    }
}
