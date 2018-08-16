package com.cuihui.platform.utils.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis集群配置文件
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisProperties {

    /**
     * redis集群节点
     */
    private String nodes;

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

}
