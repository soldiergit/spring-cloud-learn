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
    <li>msa-weather-collection-server：天气预报系统微服务架构之天气数据采集微服务</li>
    <li>msa-weather-data-server：天气项目微服务架构之天气数据API微服务</li>
</ol>