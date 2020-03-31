package com.soldier.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author soldier
 * @Date 20-3-16 下午4:41
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: xml文件解析工具类
 *   实现：xml文件 - 解析 - 映射 - 到JavaBean【第三步，下一步到CityDataServiceImpl.class】
 */
public class XmlBuilder {
    /**
     * 将xml文件转为指定实体
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {

        Object xmlObject = null;
        // 文件流
        Reader reader = null;

        // JAXBContext提供了xml转实体的接口
        JAXBContext context = JAXBContext.newInstance(clazz);
        // Unmarshaller能讲xml解析为对象
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }

        return xmlObject;
    }
}
