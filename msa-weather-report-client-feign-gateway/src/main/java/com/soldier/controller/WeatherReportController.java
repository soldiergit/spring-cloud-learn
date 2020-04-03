package com.soldier.controller;

import com.soldier.service.GatewayClient;
import com.soldier.service.WeatherReportService;
import com.soldier.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-24 上午10:12
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:天气预报控制层
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private GatewayClient gatewayClient;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) throws Exception {

        model.addAttribute("title", "黄结的天气预报系统");
        model.addAttribute("cityId", cityId);
        // 从城市列表API微服务来获取数据
        List<City> cityList = gatewayClient.cityList();
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getWeatherDataByCityId(cityId));

        // 返回：视图名称  模型名称    模型
        return new ModelAndView("weather/report", "reportModel", model);
    }

//    @GetMapping("/cityName/{cityName}")
//    public Weather getReportByCityName(@PathVariable String cityName) {
//        return weatherReportService.getDataByCityId(cityName);
//    }
}
