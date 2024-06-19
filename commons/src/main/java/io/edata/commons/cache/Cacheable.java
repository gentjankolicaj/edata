package io.edata.commons.cache;

public interface Cacheable<T> {

  T getValue();

  Class<?> getClazz();

}
