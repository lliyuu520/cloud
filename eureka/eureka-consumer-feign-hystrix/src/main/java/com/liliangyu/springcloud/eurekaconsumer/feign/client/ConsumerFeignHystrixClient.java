package com.liliangyu.springcloud.eurekaconsumer.feign.client;

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
@FeignClient(name = "eureka-consumer", fallbackFactory = ConsumerFeignHystrixClient.ConsumerFeignHystrixFallbackFactory.class)
public interface ConsumerFeignHystrixClient {
    @GetMapping("eurekaConsumer")
    String getOne();

//    /**
//     * 回退
//     */
//    @Component
//     class ConsumerFeignHystrixRollback implements ConsumerFeignHystrixClient {
//        /**
//         * logger 日志
//         */
//
//        private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignHystrixRollback.class);
//
//        @Override
//        public String getOne() {
//            LOGGER.error("getOne error");
//            return "feignRollBack";
//        }
//    }

    @Component
    class ConsumerFeignHystrixFallbackFactory implements FallbackFactory<ConsumerFeignHystrixClient>{
        /**
         * logger 日志
         */
        private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignHystrixFallbackFactory.class);

        @Override
        public ConsumerFeignHystrixClient create(final Throwable throwable) {

            return new ConsumerFeignHystrixClient() {
                @Override
                public String getOne() {
                    LOGGER.error("fallbackFactory", throwable);
                    return "fallbackFactory";
                }
            };
        }
    }
}
