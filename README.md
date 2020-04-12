# 天气项目

## 相关技术
<ul>
    <li>redis</li>
    <li>quartz</li>
</ul>

### 启动redis
查看redis运行状态（默认开机自启）
```text
sudo /etc/init.d/redis-server status
```
启动redis服务端
```text
redis-server
```
启动客户端（必须先启动服务端）
```text
redis-cli
```

## 项目model结构
<ol>
    <li>micro-weather-basic：天气项目单体架构</li>
    <li>micro-weather-eureka-server：高可用服务注册中心，集成EurekaServer，实现服务的注册与发现</li>
    <li>micro-weather-eureka-client：一个eureka客户端实例</li>
    <li>msa-weather-collection-client：天气预报系统微服务架构之天气数据采集微服务(eureka客户端)</li>
    <li>msa-weather-data-client：天气项目微服务架构之天气数据API微服务(eureka客户端)</li>
    <li>msa-weather-report-client：天气预报系统微服务架构之天气预报微服务(eureka客户端)</li>
    <li>msa-weather-city-client：天气预报系统微服务架构之城市列表API微服务(eureka客户端)</li>
    <li>micro-weather-eureka-client-feign：一个eureka客户端，使用Feign成为微服务消费者实例</li>
    <li>msa-weather-collection-client-feign：天气数据采集微服务使用Feign(eureka client+Feign)</li>
    <li>msa-weather-report-client-feign：【升级】天气预报系统微服务架构之天气预报微服务(eureka client+Feign微服务消费者)</li>
    <li>micro-weather-eureka-client-zuul：一个eureka客户端，使用Zuul实现API网关实例</li>
    <li>msa-weather-eureka-client-zuul：{聚合微服务}城市信息列表+天气数据微服务的API网关的路由配置规则(eureka client+Zuul)</li>
    <li>msa-weather-report-client-feign-gateway：【再升级】使用API网关消费zuul对天气预报微服务重构(eureka client+Feign微服务消费者)</li>
    <li>micro-weather-config-server：spring cloud config server端实例（eureka client）</li>
    <li>micro-weather-config-client：spring cloud config client端实例（eureka client）</li>
    <li>micro-weather-eureka-client-feign-hystrix：一个hystrix断路器实例（eureka client、Feign服务消费者）</li>
    <li>msa-weather-report-client-feign-gateway-hystrix：【再升级】天气预报微服务使用hystrix断路器(eureka client+Feign微服务消费者+hystrix)</li>
</ol>

## 启动项目
<ol>
    <li>首先启动【micro-weather-eureka-server】：eureka server，是各个微服务注册中心，可访问http://localhost:8761/ 查看</li>
    <li>然后启动【msa-weather-city-client】：城市列表数据API微服务，只是一个eureka client，读取本地的citylist.xml</li>
    <li>然后启动【msa-weather-collection-client-feign】：天气数据采集微服务，是一个eureka client，还是feign client-消费城市列表数据API微服务来获取城市列表，然后通过job使用httpclient获取各个城市天气数据保存到redis缓存中</li>
    <li>然后启动【msa-weather-data-client】:天气数据API微服务，只是一个eureka client，当请求进来时，从redis缓存中读取该城市的天气数据</li>
    <li>然后启动【msa-weather-eureka-client-zuul】:天气预报系统的API网关的路由配置规则，使用zuul将城市列表数据API和天气数据API微服务聚合进来，供应其它feign client微服务使用</li>
    <li>最后启动【msa-weather-report-client-feign-gateway-hystrix】：天气预报系统的用户界面，是eureka client、feign client，消费zuul网关配置的微服务；使用hystrix断路器，当zuul网关配置的微服务宕机时，会进行服务降级，进而熔断该节点微服务的调用，快速返回“错误”的响应信息</li>
    <li>访问 http://localhost:8080/report/cityId/101280302 查看</li>
</ol>
