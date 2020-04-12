package com.soldier.service;

import com.soldier.vo.City;
import com.soldier.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-4-12 上午9:14
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:当GatewayClient服务宕机时被Hystrix断路器调用的类
 */
@Component
public class GatewayClientFallback implements GatewayClient {

    /**
     * 返回一些自定义数据
     */
    @Override
    public List<City> cityList() throws Exception {

        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new City();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);

        return cityList;
    }

    /**
     * 直接修改前段
     */
    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }
}
