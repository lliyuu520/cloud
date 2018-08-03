package com.liliangyu.springcloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liliangyu
 * @description eurekaConsumer
 * @date 2018/7/30
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaConsumerHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerHystrixApplication.class, args);
    }
}
