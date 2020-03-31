package com.soldier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaWeatherReportClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWeatherReportClientApplication.class, args);
    }

}
