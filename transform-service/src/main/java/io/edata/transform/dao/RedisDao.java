package io.edata.transform.dao;

import io.edata.transform.exception.RedisDaoException;
import io.edata.transform.redis.RedisManager;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import java.util.List;

public interface RedisDao<K, V> {

  V find(K key) throws RedisDaoException;

  Long save(K key, V value) throws RedisDaoException;

  Long saveAll(K key, List<V> values) throws RedisDaoException;

  Long delete(K key) throws RedisDaoException;

  default StatefulRedisConnection<K, V> getConnection(RedisCodec<K, V> codec) {
    return RedisManager.getInstance().getRedisClient().connect(codec);
  }
}
