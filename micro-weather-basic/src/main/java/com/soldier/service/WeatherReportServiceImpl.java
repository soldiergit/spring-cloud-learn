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
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
        return weatherResponse.getData();
    }
}
