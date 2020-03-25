package com.soldier.controller;

import com.soldier.service.CityDataService;
import com.soldier.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-24 上午10:39
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:城市列表控制层
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> cityList() throws Exception {
        return cityDataService.getCityList();
    }
}
