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
    <li>msa-weather-report-client-feign：天气预报微服务使用Feign(eureka client+Feign)</li>
    <li>micro-weather-eureka-client-zuul：一个eureka客户端，使用Zuul实现API网关实例</li>
    <li>mas-weather-eureka-client-zuul：城市信息列表+天气数据微服务的API网关的路由规则(eureka client+Zuul)</li>
    <li>msa-weather-report-client-feign-gateway：天气预报微服务重构：使用API网关</li>
    <li>micro-weather-config-server：spring cloud config server端实例（eureka client）</li>
</ol>