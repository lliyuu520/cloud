package com.liliangyu.springcloud.cloud.feign.client;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient(name = "cloud-consumer", fallbackFactory = ConsumerFeignClient.ConsumerFeignHystrixFallbackFactory.class)
public interface ConsumerFeignClient {
    /**
     * 调用feign接口
     * @return
     */
    @GetMapping("eurekaConsumer")
    String getOne();

    @Component
    class ConsumerFeignHystrixFallbackFactory implements FallbackFactory<ConsumerFeignClient> {
        /**
         * logger 日志
         */
        private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignHystrixFallbackFactory.class);

        @Override
        public ConsumerFeignClient create(final Throwable throwable) {
            return () -> {
                LOGGER.error("eurekaConsumerFallbackFactory", throwable);
                return "eurekaConsumerFallbackFactory";
            };
        }
    }
}
