package com.soldier.service;

import com.soldier.vo.City;
import com.soldier.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author soldier
 * @Date 20-4-3 上午9:15
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:
 * @Description:API网关路由配置规则微服务消费者----》弃用
 *      首先通过@FeignClient指定被消费服务的名称
 *      其次通过@GetMapping来调用该服务的接口,被消费的服务怎么定义就怎么写
 */
@FeignClient("msa-weather-eureka-client-zuul")
public interface GatewayClient {

    /**
     * 获取城市列表
     *  配置信息在<msa-weather-eureka-client-zuul>
     *  会访问<msa-weather-city-client>下的'/cities'请求
     * @return
     */
    @GetMapping("/city/cities")
    List<City> cityList() throws Exception;

    /**
     * 根据id获取天气数据
     *  配置信息在<msa-weather-eureka-client-zuul>
     *  会访问<msa-weather-data-client>下的'/weather/cityId/{cityId}'请求
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable String cityId);
}
