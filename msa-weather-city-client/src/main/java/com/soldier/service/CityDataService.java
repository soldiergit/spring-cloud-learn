package com.soldier.service;

import com.soldier.vo.City;

import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-16 下午4:52
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: 城市数据接口
 */
public interface CityDataService {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> getCityList() throws Exception;

}
