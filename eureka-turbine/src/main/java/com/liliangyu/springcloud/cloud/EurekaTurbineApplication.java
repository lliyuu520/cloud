package com.liliangyu.springcloud.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author liliangyu
 * @description eurekaConsumerFeign
 * @date 2018/7/31
 */
@SpringBootApplication
@EnableTurbine
public class EurekaTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaTurbineApplication.class, args);
    }

}
