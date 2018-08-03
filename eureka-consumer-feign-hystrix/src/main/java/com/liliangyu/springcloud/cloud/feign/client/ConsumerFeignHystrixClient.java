package com.liliangyu.springcloud.cloud.feign.client;

import com.liliangyu.springcloud.cloud.feign.client.ConsumerFeignHystrixClient.ConsumerFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * consumerSumer hystrix 接口
 * @author liliangyu
 * @description feignClient
 * @date 2018/7/31
 */
@FeignClient(name = "cloud-consumer-hystrix", fallbackFactory = ConsumerFallbackFactory.class)
public interface ConsumerFeignHystrixClient {
    /**
     * 调用feign接口
     * @return
     */
    @GetMapping("eurekaConsumerHystrix")
    String getOne();

    @Component
    class ConsumerFallbackFactory implements FallbackFactory<ConsumerFeignHystrixClient> {
        /**
         * logger 日志
         */
        private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFallbackFactory.class);

        @Override
        public ConsumerFeignHystrixClient create(final Throwable throwable) {
            return () -> {
                LOGGER.error("eurekaConsumerHystrixFallbackFactory", throwable);
                return "eurekaConsumerHystrixFallbackFactory";
            };
        }
    }
}
