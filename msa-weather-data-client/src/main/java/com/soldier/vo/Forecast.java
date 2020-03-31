package com.soldier.vo;

import java.io.Serializable;

/**
 * 未来天气
 */
public class Forecast implements Serializable {

    private static final long serialVersionUID = -8592348096081790787L;

    // 日期星期
    private String date;
    // 高温
    private String high;
    // 风力
    private String fengli;
    // 低温
    private String low;
    // 风向
    private String fengxiang;
    // 类型：阴、晴、多云...
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
