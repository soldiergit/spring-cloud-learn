package com.soldier.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soldier.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 天气数据请求借口
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        String uri = WEATHER_URI + "citykey=" + cityId;

        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {

        String uri = WEATHER_URI + "city=" + cityName;

        return this.doGetWeather(uri);
    }

    /**
     * 重构
     */
    private WeatherResponse doGetWeather(String uri) {

        String weatherData =  null;
        String key =  uri;

        /**
         * redisTemplate.opsForValue();　　//操作字符串
         * redisTemplate.opsForHash();　　 //操作hash
         * redisTemplate.opsForList();　　 //操作list
         * redisTemplate.opsForSet();　　  //操作set
         * redisTemplate.opsForZSet();　 　//操作有序set
         */
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        // 先查缓存，缓存中有的就取出来
        if (stringRedisTemplate.hasKey(key)) {
            LOGGER.info("redis中有数据："+key);
            weatherData = ops.get(key);

        // 缓存中没有
        } else {
            LOGGER.info("redis中没有【"+key+"】的相关数据");
            // 直接抛出异常
            throw new RuntimeException("Redis don`t have data!");
        }

        // 将json串反序列化成实体
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = objectMapper.readValue(weatherData, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("json串反序列化成实体失败！\n"+e);
        }

        return weatherResponse;
    }
}
