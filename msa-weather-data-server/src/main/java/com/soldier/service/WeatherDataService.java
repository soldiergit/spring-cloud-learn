package com.soldier.service;

import com.soldier.vo.WeatherResponse;

/**
 * @Author soldier
 * @Date 20-3-24 上午9:54
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气数据借口
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
}
