package com.work.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 注入 zookeeper 的配置信息
 * @author: HeYin
 * @date: 2020-05-09 09:41
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

    private Integer baseSleepTimeMs;

    private Integer maxRetries;

    private String connectString;

    private Integer sessionTimeoutMs;

    private Integer connectionTimeoutMs;

}
