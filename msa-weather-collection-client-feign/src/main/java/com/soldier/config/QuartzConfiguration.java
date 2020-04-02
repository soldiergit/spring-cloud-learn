package com.soldier.config;

import com.soldier.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author soldier
 * @Date 20-3-16 下午3:40
 * @Email:583406411@qq.com
 * @Version 1.0
 * @Description: quartz配置
 */
@Configuration
public class QuartzConfiguration {

    private static final int SYNC_TIME = 1800;//更新频率 半小时

    /**
     * 构建JobDetail实例【即任务详情，它包含了任务本身和任务的其他信息】
     */
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        // newJob   绑定任务
        // withIdentity 定义任务名称
        // 添加job不带触发器必须写storeDurably()否则报如下异常，durable指明任务就算没有绑定Trigger仍保留在Quartz的JobStore中
        //     Exception in thread "main" org.quartz.SchedulerException: Jobs added with no trigger must be durable.
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    /**
     * 构建任务的触发器Trigger
     */
    @Bean
    public Trigger weatherDataSyncTrigger() {

        // 执行器
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 设置几秒钟执行一次    repeatForever:重复执行
                .withIntervalInSeconds(SYNC_TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
