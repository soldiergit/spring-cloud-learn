package com.soldier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //启用eureka client
@EnableFeignClients     //启用feign服务消费
@EnableCircuitBreaker   //启动hystrix断路器
public class MsaWeatherReportClientFeignGatewayHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWeatherReportClientFeignGatewayHystrixApplication.class, args);
    }

}
