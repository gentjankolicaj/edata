package io.edata.transform.cache;


import static java.util.Objects.isNull;

import io.edata.commons.cache.AbstractCachePool;
import io.edata.commons.cache.Cacheable;
import io.edata.commons.exception.YamlException;
import io.edata.transform.exception.LocalCacheException;
import io.edata.transform.yaml.CacheConfigYaml;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

@Slf4j
public final class LocalCachePool extends AbstractCachePool<String, List<Cacheable>> {

  private static final LocalCachePool INSTANCE = new LocalCachePool();
  private final CacheManager cacheManager;
  private final List<String> cacheKeys;

  private LocalCachePool() {
    this.cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
    this.cacheManager.init();
    this.cacheKeys = new ArrayList<>();
  }

  public static LocalCachePool getInstance() {
    return INSTANCE;
  }

  public void initCaches(List<CacheConfigYaml> cacheConfigYamls)
      throws YamlException, LocalCacheException {
    if (CollectionUtils.isEmpty(cacheConfigYamls)) {
      throw new YamlException("Error cache YAML .Yaml empty");
    } else {
      for (CacheConfigYaml cacheConfigYaml : cacheConfigYamls) {
        if (isNull(this.cacheManager.getCache(cacheConfigYaml.getKey(), String.class,
            List.class))) {
          try {
            cacheManager.createCache(cacheConfigYaml.getKey(),
                CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,
                    (Class) List.class,
                    ResourcePoolsBuilder.heap(cacheConfigYaml.getSize()).build()).build());
            cacheKeys.add(cacheConfigYaml.getKey());
            log.info("Cache '{}' details : {}", cacheConfigYaml.getKey(), cacheConfigYaml);
          } catch (Exception e) {
            log.error("Failed to create cache '{}' details : {}", cacheConfigYaml.getKey(),
                cacheConfigYaml, e);
          }
        }
      }
    }
  }

  public void clearCaches() {
    for (String key : cacheKeys) {
      this.cacheManager.removeCache(key);
    }
  }

  public Cache<String, List<Cacheable>> getCache(String key) {
    log.info("Read cache key '{}'", key);
    return this.cacheManager.getCache(key, String.class, (Class) List.class);
  }

  public void closePool() {
    this.clearCaches();
    this.cacheManager.close();
    log.info("Closed cache manager.");
  }
}
