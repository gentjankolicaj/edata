package io.edata.commons.cache;

import org.ehcache.Cache;

public abstract class AbstractCachePool<K, V> {

  public abstract void clearCaches();

  public abstract Cache<K, V> getCache(String key);

  public abstract void closePool();
}
