package com.soldier.controller;

import com.soldier.services.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author soldier
 * @Date 20-3-31 下午4:25
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @RequestMapping("/cities")
    public String cityList() {
        // 通过Feign客户端查找
        String data = cityClient.cityList();
        return data;
    }
}
