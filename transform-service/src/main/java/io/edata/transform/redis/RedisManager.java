package io.edata.transform.redis;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import io.edata.commons.exception.YamlException;
import io.edata.transform.yaml.RedisConfigYml;
import io.lettuce.core.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class RedisManager {

  private static final RedisManager INSTANCE = new RedisManager();
  private RedisClient redisClient;


  private RedisManager() {
  }

  public static RedisManager getInstance() {
    return INSTANCE;
  }

  static RedisUriBuilder urlBuilder() {
    return new RedisUriBuilder();
  }

  public void initClient(RedisConfigYml redisConfigYml) throws YamlException {
    if (isNull(redisConfigYml)) {
      throw new YamlException("Error YAML redis config.");
    }
    if (isNull(redisClient)) {
      this.redisClient = RedisClient.create(urlBuilder().redisConfigYml(redisConfigYml).build());
      log.info("Redis client created.");
    }
  }

  public void closeClient() {
    if (nonNull(redisClient)) {
      this.redisClient.close();
      this.redisClient = null;
      log.info("Redis client closed.");
    }
  }

  public RedisClient getRedisClient() {
    return redisClient;
  }

  static class RedisUriBuilder {

    private RedisConfigYml redisConfigYml;

    RedisUriBuilder() {
    }

    public RedisUriBuilder redisConfigYml(RedisConfigYml redisConfigYml) {
      this.redisConfigYml = redisConfigYml;
      return this;
    }

    public String build() {
      String sb = (redisConfigYml.isUseSSL() ? "rediss://" : "redis://")
          + (StringUtils.isNotEmpty(redisConfigYml.getPassword()) ? redisConfigYml.getPassword()
          : "")
          + (StringUtils.isNotEmpty(redisConfigYml.getHost()) ? redisConfigYml.getHost() : "")
          + ":" + redisConfigYml.getPort()
          + "/"
          + (isNull(redisConfigYml.getDatabaseNumber()) ? "" : redisConfigYml.getDatabaseNumber());
      return sb;
    }
  }
}
