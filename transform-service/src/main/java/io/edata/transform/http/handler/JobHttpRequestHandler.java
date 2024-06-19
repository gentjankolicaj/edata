package io.edata.transform.http.handler;

import static java.util.Objects.isNull;

import io.edata.commons.cache.Cacheable;
import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.edata.commons.util.JsonUtils;
import io.edata.transform.cache.LocalCachePool;
import io.edata.transform.http.HttpCacheConstants;
import io.edata.transform.yaml.HttpPathConfigYaml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.ehcache.Cache;

@Slf4j
public final class JobHttpRequestHandler implements HttpRequestHandler {

  private final HttpPathConfigYaml httpPathConfigYaml;
  private final Cache<String, List<Cacheable>> cache;

  public JobHttpRequestHandler(final HttpPathConfigYaml httpPathConfigYaml) {
    this.httpPathConfigYaml = httpPathConfigYaml;
    this.cache = LocalCachePool.getInstance().getCache(httpPathConfigYaml.getCacheKey());
  }

  @Override
  public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context)
      throws HttpException, IOException {
    log.info("Http request received {}", request);
    if (isNull(cache)) {
      log.info("Http request not cached.{}", request);
    } else {
      try {
        if (!request.getMethod().equalsIgnoreCase(httpPathConfigYaml.getMethod())) {
          log.warn("HttpMethod request received  & not impl.");
        } else {
          if (request.getUri().getPath().equals("/api/v1/nasa/temperature")) {
            PowerTemperature powerTemperature = JsonUtils.readAsString(
                EntityUtils.toString(request.getEntity()), PowerTemperature.class);
            List<Cacheable> list = cache.get(HttpCacheConstants.NASA_TEMPERATURE_V1_KEY);
            if (CollectionUtils.isEmpty(list)) {
              List<Cacheable> tmp = new ArrayList<>();
              tmp.add(powerTemperature);
              cache.put(HttpCacheConstants.NASA_TEMPERATURE_V1_KEY, list);
            } else {
              list.add(powerTemperature);
            }
            log.info("Http request cached.{} , {}", request, powerTemperature);
          } else if (request.getUri().getPath().equals("/api/v1/nasa/pressure")) {
            PowerPressure powerPressure = JsonUtils.readAsString(
                EntityUtils.toString(request.getEntity()), PowerPressure.class);
            List<Cacheable> list = cache.get(HttpCacheConstants.NASA_PRESSURE_V1_KEY);
            if (CollectionUtils.isEmpty(list)) {
              List<Cacheable> tmp = new ArrayList<>();
              tmp.add(powerPressure);
              cache.put(HttpCacheConstants.NASA_PRESSURE_V1_KEY, list);
            } else {
              list.add(powerPressure);
            }
            log.info("Http request cached.{} , {}", request, powerPressure);
          }
        }
      } catch (Exception e) {
        log.error("Http request handle error.", e);
      }
    }
  }
}
