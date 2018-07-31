package com.liliangyu.springcloud.eurekaconsumerfeign.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient("eureka-client")
public interface ConsumerFeignClient {
    @GetMapping("dc")
    String getOne();
}
