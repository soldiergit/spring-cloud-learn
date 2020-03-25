package com.soldier.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soldier.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    // 天气数据请求借口
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    // 数据失效/超时时间 1800秒
    private static final long DATA_TIMOUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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

        // 缓存中没有再从地址获取数据
        } else {
            LOGGER.info("redis中没有【"+key+"】的相关数据");
            // 从地址获取数据
            ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
            if (respStr.getStatusCodeValue() == 200) {
                weatherData = respStr.getBody();
            }

            //数据写入缓存
            // key  value   设置数据失效时间  设置时间单位
            ops.set(key, weatherData, DATA_TIMOUT, TimeUnit.SECONDS);

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

    @Override
    public void syncDataByCityId(String cityId) {

        String uri = WEATHER_URI + "citykey=" + cityId;

        this.saveWeatherData(uri);
    }

    /**
     * 保存天气数据到redis缓存中
     */
    private void saveWeatherData(String uri) {

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
        // 从地址获取数据
        ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
        if (respStr.getStatusCodeValue() == 200) {
            weatherData = respStr.getBody();
        }

        //数据写入缓存
        // key  value   设置数据失效时间  设置时间单位
        ops.set(key, weatherData, DATA_TIMOUT, TimeUnit.SECONDS);
    }
}
