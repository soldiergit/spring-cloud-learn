package com.soldier.service;

import com.soldier.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author soldier
 * @Date 20-4-2 上午8:43
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:城市信息列表API服务消费者
 *      首先通过@FeignClient指定被消费服务的名称
 *      其次通过@GetMapping来调用该服务的接口,被消费的服务怎么定义就怎么写
 */
@FeignClient("msa-weather-city-client")
public interface CityClient {

    @GetMapping("/cities")
    List<City> cityList();
}
