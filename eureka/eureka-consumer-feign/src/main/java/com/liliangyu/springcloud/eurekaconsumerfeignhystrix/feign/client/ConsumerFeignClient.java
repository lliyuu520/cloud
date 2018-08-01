package com.liliangyu.springcloud.eurekaconsumerfeignhystrix.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient("eureka-client")
public interface ConsumerFeignClient {
    /**
     * 查询
     * @return
     */
    @GetMapping("dc")
    String getOne();
}
