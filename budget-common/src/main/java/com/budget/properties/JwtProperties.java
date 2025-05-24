package com.budget.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "budget.jwt")
@Data
public class JwtProperties {

    /**
     * 成员生成jwt令牌相关配置
     */
    private String SecretKey;
    private long Ttl;
    private String TokenName;



}
