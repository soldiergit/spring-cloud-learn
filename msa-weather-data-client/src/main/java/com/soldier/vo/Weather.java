package com.soldier.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息实体
 */
public class Weather implements Serializable {

    private static final long serialVersionUID = -3454522116557768848L;

    // 城市
    private String city;
    // 空气质量指数
    private String aqi;
    // 高温情况
    private String ganmao;
    // 温度
    private String wendu;
    // 昨日天气
    private Yesterday yesterday;
    // 未来天气
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
