package com.soldier.service;

import com.soldier.vo.Weather;
import com.soldier.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author soldier
 * @Date 20-3-19 上午9:17
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气预报接口
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private  WeatherDataClient weatherDataClient;

    @Override
    public Weather getWeatherDataByCityId(String cityId) {

        // 从天气数据API微服务来获取数据
        WeatherResponse weatherResponse = weatherDataClient.getWeatherByCityId(cityId);

        return weatherResponse.getData();
    }
}
