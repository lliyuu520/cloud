package com.liliangyu.springcloud.cloud.controller.feign.hystrix;

import com.liliangyu.springcloud.cloud.feign.client.ConsumerFeignClient;
import com.liliangyu.springcloud.cloud.feign.client.ConsumerFeignHystrixClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    private ConsumerFeignHystrixClient consumerFeignHystrixClient;
    private ConsumerFeignClient consumerFeignClient;

    @Autowired
    public ConsumerController(ConsumerFeignHystrixClient consumerFeignHystrixClient, ConsumerFeignClient consumerFeignClient) {
        this.consumerFeignHystrixClient = consumerFeignHystrixClient;
        this.consumerFeignClient = consumerFeignClient;
    }

    @GetMapping("consumerFeign")
    public String getOne() {
        LOGGER.info(LocalDateTime.now().toString());
        return consumerFeignHystrixClient.getOne();
    }

    @GetMapping("consumerFeignHystrix")
    public String getOne1() {
        LOGGER.info(LocalDateTime.now().toString());
        return consumerFeignClient.getOne();

    }
}
