package com.soldier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author soldier
 * @Date 20-3-24 上午9:30
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气数据采集服务
 */
@Service
public class WeatherDataCollectionServerImpl implements WeatherDataCollectionServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataCollectionServerImpl.class);

    // 天气数据请求借口
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    // 数据失效/超时时间 1800秒
    private static final long DATA_TIMOUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncWeatherDataByCityId(String cityId) {

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
