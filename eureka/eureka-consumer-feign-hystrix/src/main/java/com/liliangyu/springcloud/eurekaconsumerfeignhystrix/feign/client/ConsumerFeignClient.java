package com.liliangyu.springcloud.eurekaconsumerfeignhystrix.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient(name="eureka-client",fallback=ConsumerFeignRollback.class)
public interface ConsumerFeignClient {
    @GetMapping("dc")
    String getOne();
}
