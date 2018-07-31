package com.liliangyu.springcloud.eurekaconsumerfeign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liliangyu
 * @description consumerController
 * @date 2018/7/30
 */
@RestController
public class ConsumerController {
    /**
     * logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;
@Autowired
    DiscoveryClient discoveryClient;
    @GetMapping
    public String getOne() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        String forObject = restTemplate.getForObject("http://eureka-client/dc", String.class);
        LOGGER.info("11111111");
        return forObject + "ribbon";
    }

}
