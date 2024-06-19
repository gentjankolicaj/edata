package io.edata.transform.job.nasa;


import static java.util.Objects.nonNull;

import io.edata.commons.cache.Cacheable;
import io.edata.commons.job.Job;
import io.edata.commons.job.result.SimpleMeta;
import io.edata.transform.cache.LocalCachePool;
import io.edata.transform.dao.PowerPressureDao;
import io.edata.transform.dao.PowerTemperatureDao;
import io.edata.transform.dao.impl.PowerPressureDaoImpl;
import io.edata.transform.dao.impl.PowerTemperatureDaoImpl;
import io.edata.transform.http.HttpCacheConstants;
import io.edata.transform.yaml.JobConfigYaml;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.ehcache.Cache;


@Slf4j
public class NasaJob implements Job<NasaJobResult<SimpleMeta, Object>> {

  private final JobConfigYaml jobConfigYaml;
  private final LocalCachePool localCachePool;
  private final PowerPressureDao powerPressureDao;
  private final PowerTemperatureDao powerTemperatureDao;

  public NasaJob(JobConfigYaml jobConfigYaml) {
    this.jobConfigYaml = jobConfigYaml;
    this.localCachePool = LocalCachePool.getInstance();
    this.powerPressureDao = new PowerPressureDaoImpl();
    this.powerTemperatureDao = new PowerTemperatureDaoImpl();
  }

  @Override
  public NasaJobResult<SimpleMeta, Object> call() throws Exception {
    boolean flag = true;
    int attempt = 0;
    List<String> cacheKeys = jobConfigYaml.getCacheKeys();
    do {
      try {
        long startTime = System.currentTimeMillis();
        if (CollectionUtils.isNotEmpty(cacheKeys)) {
          for (String cacheKey : cacheKeys) {
            Cache<String, List<Cacheable>> cache = localCachePool.getCache(cacheKey);
            if (nonNull(cache)) {
              for (Iterator<Cache.Entry<String, List<Cacheable>>> it = cache.iterator();
                  it.hasNext(); ) {
                store(it.next());
              }
            }
          }
        }
        Thread.sleep(jobConfigYaml.getSleep());
        log.error("Job '{}' run {} millis.", jobConfigYaml.getName(),
            System.currentTimeMillis() - startTime);
      } catch (Exception e) {
        attempt++;
        log.error("Job '{}' error {} ", jobConfigYaml.getName(), e.getMessage(), e);
        Thread.currentThread().interrupt();
      }
      if (attempt >= jobConfigYaml.getFailedAttemptMax()) {
        return new NasaJobResult<>(new SimpleMeta(1), null);
      }
    } while (flag);
    return new NasaJobResult<>(new SimpleMeta(0), null);
  }

  private void store(Cache.Entry<String, List<Cacheable>> entry) {
    try {
      if (nonNull(entry)) {
        if (nonNull(entry.getKey()) && entry.getKey()
            .equalsIgnoreCase(HttpCacheConstants.NASA_PRESSURE_V1_KEY)) {
          powerPressureDao.saveAll(System.currentTimeMillis(), (List) entry.getValue());
        } else if (nonNull(entry.getKey()) && entry.getKey()
            .equalsIgnoreCase(HttpCacheConstants.NASA_TEMPERATURE_V1_KEY)) {
          powerTemperatureDao.saveAll(System.currentTimeMillis(), (List) entry.getValue());
        }
      }
    } catch (Exception e) {
      log.error("Job '{}' failed to persist cache on redis.", jobConfigYaml.getName(), e);
    }
  }
}
