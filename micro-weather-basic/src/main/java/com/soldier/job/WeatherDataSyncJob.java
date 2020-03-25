package com.soldier.job;

import com.soldier.service.CityDataService;
import com.soldier.service.WeatherDataService;
import com.soldier.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-16 下午3:37
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: 自动从天气接口同步天气数据【任务】类
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("自动从天气接口同步城市天气数据的任务 Start！");

        // 获取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.getCityList();
        } catch (Exception e) {
            LOGGER.error("从citylist.xml中读取城市列表失败", e);
        }

        // 遍历城市列表获取天气
        for (City city: cityList) {
            String cityId = city.getCityId();

            weatherDataService.syncDataByCityId(cityId);
            LOGGER.info("同步城市【"+city.getCityName()+"】，id为【"+cityId+"】到redis缓存中！");
        }

        LOGGER.info("自动从天气接口同步城市天气数据的任务 End！");
    }
}
