package com.liliangyu.springcloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author liliangyu
 * @description eurekaConsumerFeign
 * @date 2018/7/31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaConsumerFeignZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignZipkinApplication.class, args);
    }

}
