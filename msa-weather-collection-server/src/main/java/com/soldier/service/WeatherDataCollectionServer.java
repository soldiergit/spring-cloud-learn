package com.soldier.service;

/**
 * @Author soldier
 * @Date 20-3-24 上午9:27
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气数据采集服务
 */
public interface WeatherDataCollectionServer {

    void syncWeatherDataByCityId(String cityId);
}
