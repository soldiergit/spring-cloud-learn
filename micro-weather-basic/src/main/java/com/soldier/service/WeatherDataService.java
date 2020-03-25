package com.soldier.service;

import com.soldier.vo.WeatherResponse;

/**
 * 天气数据借口
 */
public interface WeatherDataService {
    /**
     * 根据城市id查询天气数据
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市id查询天气数据
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市id同步其天气数据
     */
    void syncDataByCityId(String cityId);
}
