package com.soldier.service;

import com.soldier.vo.Forecast;
import com.soldier.vo.Weather;
import com.soldier.vo.WeatherResponse;
import com.soldier.vo.Yesterday;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-19 上午9:17
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气预报接口
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getWeatherDataByCityId(String cityId) {
        // TODO 从天气数据API微服务来获取数据
        Weather weather = new Weather();
        weather.setAqi("81");
        weather.setCity("博罗");
        weather.setGanmao("容易感冒");
        weather.setWendu("32");

        List<Forecast> forecastList = new ArrayList<>();
        int i = 5;
        Forecast forecast;
        while (i > 0) {
            forecast = new Forecast();
            forecast.setDate("2020-03-2"+i);
            forecast.setFengli("5级");
            forecast.setFengxiang("西北"+i);
            forecast.setHigh("高温"+i);
            forecast.setLow("低温"+i);
            forecast.setType("晴"+i);
            forecastList.add(forecast);
            i--;
        }
        weather.setForecast(forecastList);

        Yesterday yesterday = new Yesterday();
        yesterday.setDate("2020-03-19");
        yesterday.setFl("5级");
        yesterday.setFx("西北"+i);
        yesterday.setHigh("高温"+i);
        yesterday.setLow("低温"+i);
        yesterday.setType("晴"+i);
        weather.setYesterday(yesterday);

        return weather;
    }
}
