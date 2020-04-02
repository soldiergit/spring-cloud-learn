package com.soldier.service;

import com.soldier.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author soldier
 * @Date 20-4-2 上午8:45
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气数据API服务消费者
 *      首先通过@FeignClient指定被消费服务的名称
 *      其次通过@GetMapping来调用该服务的接口,被消费的服务怎么定义就怎么写
 */
@FeignClient("msa-weather-data-client")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable String cityId);
}
