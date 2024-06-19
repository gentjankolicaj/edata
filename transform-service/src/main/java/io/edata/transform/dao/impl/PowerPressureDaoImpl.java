package io.edata.transform.dao.impl;

import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.transform.dao.PowerPressureDao;
import io.edata.transform.exception.RedisDaoException;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class PowerPressureDaoImpl implements PowerPressureDao {

  private final StatefulRedisConnection<Long, PowerPressure> connection;

  public PowerPressureDaoImpl() {
    this.connection = getConnection(new PowerPressureCodec());
  }

  @Override
  public PowerPressure find(Long key) throws RedisDaoException {
    return connection.sync().get(key);
  }

  @Override
  public Long save(Long key, PowerPressure value) throws RedisDaoException {
    return connection.sync().sadd(key, value);
  }

  @Override
  public Long saveAll(Long key, List<PowerPressure> values) throws RedisDaoException {
    return connection.sync().sadd(key, values.toArray(new PowerPressure[values.size()]));
  }

  @Override
  public Long delete(Long key) throws RedisDaoException {
    return connection.sync().del(key);
  }


  static class PowerPressureCodec implements RedisCodec<Long, PowerPressure> {

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
    public PowerPressure decodeValue(ByteBuffer byteBuffer) {
      try {
        byte[] array = new byte[byteBuffer.remaining()];
        byteBuffer.get(array);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
        return (PowerPressure) ois.readObject();
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
    public ByteBuffer encodeValue(PowerPressure powerPressure) {
      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(powerPressure);
        return ByteBuffer.wrap(bos.toByteArray());
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
  }
}
