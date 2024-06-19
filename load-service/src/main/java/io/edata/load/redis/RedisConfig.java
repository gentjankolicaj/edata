package io.gentjankolicaj.app.edata.load.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}}")
  private String host;

  @Value("${spring.redis.username}}")
  private String username;

  @Value("${spring.redis.password}}")
  private String password;

  @Value("${spring.redis.port}")
  private int port;

  @Value("${spring.redis.database}")
  private int databaseNumber;

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    jedisConnectionFactory.setHostName(host);
    jedisConnectionFactory.setPort(port);
    jedisConnectionFactory.setDatabase(databaseNumber);
    jedisConnectionFactory.setClientName(username);
    jedisConnectionFactory.setPassword(password);
    return jedisConnectionFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }
}
