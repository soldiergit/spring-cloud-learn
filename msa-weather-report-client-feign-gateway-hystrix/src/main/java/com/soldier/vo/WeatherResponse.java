package com.soldier.vo;

import java.io.Serializable;

/**
 * 天气数据的响应实体
 */
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = -4233165602960631604L;

    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}