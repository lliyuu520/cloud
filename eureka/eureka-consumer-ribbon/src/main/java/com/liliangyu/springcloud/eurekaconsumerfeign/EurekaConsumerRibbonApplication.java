package com.liliangyu.springcloud.eurekaconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author liliangyu
 * @description eurekaConsumerRibbon 启动器
 * @date 2018/7/30
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumerRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
