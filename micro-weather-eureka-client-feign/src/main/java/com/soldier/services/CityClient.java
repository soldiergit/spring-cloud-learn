package com.soldier.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author soldier
 * @Date 20-3-31 下午4:21
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:城市信息客户端
 *      首先通过@FeignClient指定被调用服务的名称
 *      其次通过@GetMapping来调用该服务的接口
 */
@FeignClient("msa-weather-city-client")
public interface CityClient {

    @GetMapping("/cities")
    String cityList();
}
