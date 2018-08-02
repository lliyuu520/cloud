package com.liliangyu.springcloud.eurekaconsumer.controller.feign.hystrix;

import com.liliangyu.springcloud.eurekaconsumer.feign.client.ConsumerFeignHystrixClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Autowired
    private ConsumerFeignHystrixClient consumerFeignHystrixClient;



    @GetMapping("feign/hystrix")
    public String getOne() {
        String one = consumerFeignHystrixClient.getOne();
        return one;
    }
}
