package io.edata.transform.cache;

import static org.assertj.core.api.Assertions.assertThat;

import io.edata.commons.cache.Cacheable;
import io.edata.commons.cache.types.CacheableDouble;
import io.edata.commons.cache.types.CacheableLong;
import io.edata.commons.cache.types.CacheableString;
import io.edata.transform.TransformApplication;
import io.edata.transform.yaml.ApplicationConfigYaml;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.ehcache.Cache;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LocalCachePoolTest {

  static LocalCachePool localCachePool;

  @BeforeAll
  static void setup() {
    localCachePool = LocalCachePool.getInstance();
  }

  @Order(1)
  @Test
  void initAndClear() throws Exception {
    ApplicationConfigYaml applicationConfigYaml = TransformApplication.getConfigurationYaml();
    assertThat(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches())).isTrue();
    localCachePool.initCaches(applicationConfigYaml.getCaches());
    localCachePool.clearCaches();

  }

  @Order(2)
  @Test
  void get() throws Exception {
    ApplicationConfigYaml applicationConfigYaml = TransformApplication.getConfigurationYaml();
    assertThat(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches())).isTrue();
    String nasaCacheKey = "nasa-cache-temperature";
    localCachePool.initCaches(applicationConfigYaml.getCaches());

    Cache<String, List<Cacheable>> nasaCache = localCachePool.getCache(nasaCacheKey);
    assertThat(nasaCache).isNotNull();
    String sValue = "Hello World";
    Double dValue = Double.valueOf(3.14);
    Long lValue = Long.valueOf(1);

    nasaCache.put("1L", List.of(new CacheableString(sValue)));
    nasaCache.put("2L", List.of(new CacheableLong(lValue)));
    nasaCache.put("3L", List.of(new CacheableDouble(dValue)));

    assertThat(nasaCache.get("1L").get(0).getValue() == sValue).isTrue();
    assertThat(nasaCache.get("2L").get(0).getValue() == lValue).isTrue();
    assertThat(nasaCache.get("3L").get(0).getValue() == dValue).isTrue();
    localCachePool.clearCaches();
  }

  @Order(3)
  @Test
  void close() {
    localCachePool.closePool();
  }
}