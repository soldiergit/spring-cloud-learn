package com.soldier.service;

import com.soldier.vo.Weather;

/**
 * @Author soldier
 * @Date 20-3-19 上午9:16
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气预报接口
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
