package com.liliangyu.springcloud.cloud.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient("eureka-consumer")
public interface ConsumerZipkinFeignClient {
    /**
     * 查询
     * @return
     */
    @GetMapping("eurekaConsumer")
    String getOne();
}
