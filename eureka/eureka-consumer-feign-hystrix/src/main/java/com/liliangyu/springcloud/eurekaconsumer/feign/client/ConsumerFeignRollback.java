package com.liliangyu.springcloud.eurekaconsumer.feign.client;

import org.springframework.stereotype.Component;

/**
 * @author liliangyu
 * @description rollback
 * @date 2018/7/31
 */
@Component
public class ConsumerFeignRollback implements ConsumerFeignClient {

    @Override
    public String getOne() {
        return "feignRollBack";
    }
}
