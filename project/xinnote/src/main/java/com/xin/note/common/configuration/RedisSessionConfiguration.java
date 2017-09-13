package com.xin.note.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300,redisNamespace = "demoapp")
public class RedisSessionConfiguration {
}
