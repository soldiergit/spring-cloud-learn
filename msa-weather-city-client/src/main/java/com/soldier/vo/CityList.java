package com.soldier.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-16 下午4:37
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: 一个承载城市信息集合的类
 *  实现：xml文件 - 解析 - 映射 - 到JavaBean【第二步，下一步到XmlBuilder.class】
 *      XmlAccessorType  指定访问xml文件的类型
 *      XmlRootElement里的name对应citylist.xml中的<c></c>标签名称
 *      XmlElement(取的是标签)里的name对应citylist.xml中<d></d>标签名称
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "c")
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
