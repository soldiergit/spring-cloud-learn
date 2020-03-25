package com.soldier.service;

import com.soldier.util.XmlBuilder;
import com.soldier.vo.City;
import com.soldier.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author soldier
 * @Date 20-3-16 下午4:54
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description:
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    /**
     * 实现：xml文件 - 解析 - 映射 - 到JavaBean【第四步】
     */
    @Override
    public List<City> getCityList() throws Exception {

        // 读取xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        bufferedReader.close();

        // xml转Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());

        return cityList.getCityList();
    }
}
