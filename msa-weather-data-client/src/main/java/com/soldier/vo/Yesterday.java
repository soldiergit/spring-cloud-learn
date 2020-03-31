package com.soldier.vo;

import java.io.Serializable;

/**
 * 昨日天气
 */
public class Yesterday implements Serializable {

    private static final long serialVersionUID = -3618996413280127734L;

    // 日期星期
    private String date;
    // 高温
    private String high;
    // 风向
    private String fx;
    // 低温
    private String low;
    // 风力
    private String fl;
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

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
