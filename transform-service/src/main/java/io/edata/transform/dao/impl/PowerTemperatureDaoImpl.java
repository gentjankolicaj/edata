package io.edata.transform.dao.impl;

import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.edata.transform.dao.PowerTemperatureDao;
import io.edata.transform.exception.RedisDaoException;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class PowerTemperatureDaoImpl implements PowerTemperatureDao {

  private final StatefulRedisConnection<Long, PowerTemperature> connection;

  public PowerTemperatureDaoImpl() {
    this.connection = getConnection(new PowerTemperatureCodec());
  }

  @Override
  public PowerTemperature find(Long key) throws RedisDaoException {
    return connection.sync().get(key);
  }

  @Override
  public Long save(Long key, PowerTemperature value) throws RedisDaoException {
    return connection.sync().sadd(key, value);
  }

  @Override
  public Long saveAll(Long key, List<PowerTemperature> values) throws RedisDaoException {
    return connection.sync().sadd(key, values.toArray(new PowerTemperature[values.size()]));
  }

  @Override
  public Long delete(Long key) throws RedisDaoException {
    return connection.sync().del(key);
  }


  static class PowerTemperatureCodec implements RedisCodec<Long, PowerTemperature> {

    @Override
    public Long decodeKey(ByteBuffer byteBuffer) {
      try {
        byte[] array = new byte[byteBuffer.remaining()];
        byteBuffer.get(array);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
        return ois.readLong();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public PowerTemperature decodeValue(ByteBuffer byteBuffer) {
      try {
        byte[] array = new byte[byteBuffer.remaining()];
        byteBuffer.get(array);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
        return (PowerTemperature) ois.readObject();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public ByteBuffer encodeKey(Long aLong) {
      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(aLong);
        return ByteBuffer.wrap(bos.toByteArray());

      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public ByteBuffer encodeValue(PowerTemperature powerTemperature) {
      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(powerTemperature);
        return ByteBuffer.wrap(bos.toByteArray());
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }
}
