package com.soldier.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author soldier
 * @Date 20-3-16 下午4:28
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: 城市实体类
 *  实现：xml文件 - 解析 - 映射 - 到JavaBean【第一步，下一步到CityList.class】
 *      XmlAccessorType  指定访问xml文件的类型
 *      XmlRootElement里的name对应citylist.xml中的<d></d>标签名称
 *      XmlAttribute(取的是标签下的元素)里的name对应citylist.xml中<d></d>标签里的属性名称
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "d")
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "d4")
    private String province;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
