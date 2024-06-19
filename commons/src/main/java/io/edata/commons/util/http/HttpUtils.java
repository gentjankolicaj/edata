package io.edata.commons.util.http;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import io.edata.commons.util.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpOptions;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;

@Slf4j
public class HttpUtils {

  private HttpUtils() {
  }

  public static <T> T get(String uri, Class<T> clazz) throws IOException, ParseException {
    return get(uri, new HttpQueryParams(null), null, null, clazz);
  }

  public static <T> T get(String uri, Object body, Class<T> clazz)
      throws IOException, ParseException {
    return get(uri, new HttpQueryParams(null), null, new HttpBody(HttpBodyType.JSON, body), clazz);
  }

  public static <T> T get(String uri, Map<String, Object> queryParams, Map<String, Object> headers,
      Object body, Class<T> clazz) throws IOException, ParseException {
    return get(uri, new HttpQueryParams(queryParams),
        new io.edata.commons.util.http.HttpHeaders(headers), new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T get(String uri, HttpQueryParams httpQueryParams,
      io.edata.commons.util.http.HttpHeaders httpHeaders, HttpBody httpBody, Class<T> clazz)
      throws IOException, ParseException {
    if (StringUtils.isEmpty(uri)) {
      throw new IllegalArgumentException("Uri can't be null or empty.");
    }

    if (isNull(clazz)) {
      throw new IllegalArgumentException("Class of return type can't be null.");
    }

    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
      String customUri = nonNull(httpQueryParams) ? uri + buildQueryParams(
          MapUtils.emptyIfNull(httpQueryParams.getPairs())) : uri;
      HttpGet httpGet = new HttpGet(customUri);
      if (nonNull(httpHeaders) && MapUtils.isNotEmpty(httpHeaders.getPairs())) {
        httpHeaders.getPairs().forEach(httpGet::setHeader);
      }
      if (nonNull(httpBody) && nonNull(httpBody.getData())) {
        HttpEntity httpEntity = buildHttpEntity(httpBody);
        httpGet.setEntity(httpEntity);
      }
      log.info("Executing http-get at uri {}", customUri);
      return httpClient.execute(httpGet, getResponseHandler(clazz));
    }
  }


  public static <T> T post(String uri, Class<T> clazz) throws IOException, ParseException {
    return post(uri, new HttpQueryParams(null), null, null, clazz);
  }

  public static <T> T post(String uri, Object body, Class<T> clazz)
      throws IOException, ParseException {
    return post(uri, new HttpQueryParams(null), null, new HttpBody(HttpBodyType.JSON, body), clazz);
  }

  public static <T> T post(String uri, Map<String, Object> queryParams, Map<String, Object> headers,
      Object body, Class<T> clazz) throws IOException, ParseException {
    return post(uri, new HttpQueryParams(queryParams),
        new io.edata.commons.util.http.HttpHeaders(headers), new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T post(String uri, HttpQueryParams httpQueryParams,
      io.edata.commons.util.http.HttpHeaders httpHeaders, HttpBody httpBody, Class<T> clazz)
      throws IOException, ParseException {
    if (StringUtils.isEmpty(uri)) {
      throw new IllegalArgumentException("Uri can't be null or empty.");
    }

    if (isNull(clazz)) {
      throw new IllegalArgumentException("Class of return type can't be null.");
    }

    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
      String customUri = nonNull(httpQueryParams) ? uri + buildQueryParams(
          MapUtils.emptyIfNull(httpQueryParams.getPairs())) : uri;
      HttpPost httpPost = new HttpPost(customUri);
      if (nonNull(httpHeaders) && MapUtils.isNotEmpty(httpHeaders.getPairs())) {
        httpHeaders.getPairs().forEach(httpPost::setHeader);
      }
      if (nonNull(httpBody) && nonNull(httpBody.getData())) {
        HttpEntity httpEntity = buildHttpEntity(httpBody);
        httpPost.setEntity(httpEntity);
      }
      log.info("Executing http-post at uri {}", customUri);
      return httpClient.execute(httpPost, getResponseHandler(clazz));
    }
  }

  public static <T> T put(String uri, Class<T> clazz) throws IOException, ParseException {
    return put(uri, new HttpQueryParams(null), null, null, clazz);
  }

  public static <T> T put(String uri, Object body, Class<T> clazz)
      throws IOException, ParseException {
    return put(uri, new HttpQueryParams(null), null, new HttpBody(HttpBodyType.JSON, body), clazz);
  }

  public static <T> T put(String uri, Map<String, Object> queryParams, Map<String, Object> headers,
      Object body, Class<T> clazz) throws IOException, ParseException {
    return put(uri, new HttpQueryParams(queryParams),
        new io.edata.commons.util.http.HttpHeaders(headers), new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T put(String uri, HttpQueryParams httpQueryParams,
      io.edata.commons.util.http.HttpHeaders httpHeaders, HttpBody httpBody, Class<T> clazz)
      throws IOException, ParseException {
    if (StringUtils.isEmpty(uri)) {
      throw new IllegalArgumentException("Uri can't be null or empty.");
    }

    if (isNull(clazz)) {
      throw new IllegalArgumentException("Class of return type can't be null.");
    }

    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
      String customUri = nonNull(httpQueryParams) ? uri + buildQueryParams(
          MapUtils.emptyIfNull(httpQueryParams.getPairs())) : uri;
      HttpPut httpPut = new HttpPut(customUri);
      if (nonNull(httpHeaders) && MapUtils.isNotEmpty(httpHeaders.getPairs())) {
        httpHeaders.getPairs().forEach(httpPut::setHeader);
      }
      if (nonNull(httpBody) && nonNull(httpBody.getData())) {
        HttpEntity httpEntity = buildHttpEntity(httpBody);
        httpPut.setEntity(httpEntity);
      }
      log.info("Executing http-put at uri {}", customUri);
      return httpClient.execute(httpPut, getResponseHandler(clazz));
    }
  }


  public static <T> T delete(String uri, Class<T> clazz) throws IOException, ParseException {
    return delete(uri, new HttpQueryParams(null), null, null, clazz);
  }

  public static <T> T delete(String uri, Object body, Class<T> clazz)
      throws IOException, ParseException {
    return delete(uri, new HttpQueryParams(null), null, new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T delete(String uri, Map<String, Object> queryParams,
      Map<String, Object> headers, Object body, Class<T> clazz) throws IOException, ParseException {
    return delete(uri, new HttpQueryParams(queryParams),
        new io.edata.commons.util.http.HttpHeaders(headers), new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T delete(String uri, HttpQueryParams httpQueryParams,
      io.edata.commons.util.http.HttpHeaders httpHeaders, HttpBody httpBody, Class<T> clazz)
      throws IOException, ParseException {
    if (StringUtils.isEmpty(uri)) {
      throw new IllegalArgumentException("Uri can't be null or empty.");
    }

    if (isNull(clazz)) {
      throw new IllegalArgumentException("Class of return type can't be null.");
    }

    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
      String customUri = nonNull(httpQueryParams) ? uri + buildQueryParams(
          MapUtils.emptyIfNull(httpQueryParams.getPairs())) : uri;
      HttpDelete httpDelete = new HttpDelete(customUri);
      if (nonNull(httpHeaders) && MapUtils.isNotEmpty(httpHeaders.getPairs())) {
        httpHeaders.getPairs().forEach(httpDelete::setHeader);
      }
      if (nonNull(httpBody) && nonNull(httpBody.getData())) {
        HttpEntity httpEntity = buildHttpEntity(httpBody);
        httpDelete.setEntity(httpEntity);
      }
      log.info("Executing http-delete at uri {}", customUri);
      return httpClient.execute(httpDelete, getResponseHandler(clazz));
    }
  }

  public static <T> T options(String uri, Class<T> clazz) throws IOException, ParseException {
    return options(uri, new HttpQueryParams(null), null, null, clazz);
  }

  public static <T> T options(String uri, Object body, Class<T> clazz)
      throws IOException, ParseException {
    return options(uri, new HttpQueryParams(null), null, new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T options(String uri, Map<String, Object> queryParams,
      Map<String, Object> headers, Object body, Class<T> clazz) throws IOException, ParseException {
    return options(uri, new HttpQueryParams(queryParams),
        new io.edata.commons.util.http.HttpHeaders(headers), new HttpBody(HttpBodyType.JSON, body),
        clazz);
  }

  public static <T> T options(String uri, HttpQueryParams httpQueryParams, HttpHeaders httpHeaders,
      HttpBody httpBody, Class<T> clazz) throws IOException, ParseException {
    if (StringUtils.isEmpty(uri)) {
      throw new IllegalArgumentException("Uri can't be null or empty.");
    }

    if (isNull(clazz)) {
      throw new IllegalArgumentException("Class of return type can't be null.");
    }

    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
      String customUri = nonNull(httpQueryParams) ? uri + buildQueryParams(
          MapUtils.emptyIfNull(httpQueryParams.getPairs())) : uri;
      HttpOptions httpOptions = new HttpOptions(customUri);
      if (nonNull(httpHeaders) && MapUtils.isNotEmpty(httpHeaders.getPairs())) {
        httpHeaders.getPairs().forEach(httpOptions::setHeader);
      }
      if (nonNull(httpBody) && nonNull(httpBody.getData())) {
        HttpEntity httpEntity = buildHttpEntity(httpBody);
        httpOptions.setEntity(httpEntity);
      }
      log.info("Executing http-options at uri {}", customUri);
      return httpClient.execute(httpOptions, getResponseHandler(clazz));
    }
  }

  private static <T> HttpClientResponseHandler<T> getResponseHandler(Class<T> clazz) {
    return new HttpClientResponseHandler<T>() {
      @Override
      public T handleResponse(ClassicHttpResponse classicHttpResponse)
          throws HttpException, IOException {
        String content = EntityUtils.toString(classicHttpResponse.getEntity(),
            Charset.defaultCharset());
        log.info("Http response body {}", content);
        if (clazz.getName().equals(String.class.getName())) {
          return (T) content;
        } else {
          return JsonUtils.readAsString(content, clazz);
        }
      }
    };
  }

  private static String buildQueryParams(Map<String, Object> map) {
    if (MapUtils.isEmpty(map)) {
      return StringUtils.EMPTY;
    } else {
      StringBuilder sb = new StringBuilder("?");
      int size = map.size();
      int index = 0;
      for (Map.Entry<String, Object> entry : map.entrySet()) {
        sb.append(entry.getKey()).append("=").append(entry.getKey());
        if (index + 1 < size) {
          sb.append("&");
        }
        index++;
      }
      return sb.toString();
    }
  }

  private static HttpEntity buildHttpEntity(HttpBody httpBody) {
    if (httpBody.getType().equals(HttpBodyType.TEXT)) {
      return new StringEntity((String) httpBody.getData(), ContentType.TEXT_PLAIN);
    } else if (httpBody.getType().equals(HttpBodyType.XML)) {
      return new StringEntity((String) httpBody.getData(), ContentType.TEXT_XML);
    } else if (httpBody.getType().equals(HttpBodyType.HTML)) {
      return new StringEntity((String) httpBody.getData(), ContentType.TEXT_HTML);
    } else if (httpBody.getType().equals(HttpBodyType.JSON)) {
      return new StringEntity(JsonUtils.writeValueAsString(httpBody.getData()),
          ContentType.APPLICATION_JSON);
    } else if (httpBody.getType().equals(HttpBodyType.FILE) || httpBody.getType()
        .equals(HttpBodyType.BINARY)) {
      return new FileEntity((File) httpBody.getData(), ContentType.DEFAULT_BINARY);
    } else if (httpBody.getType().equals(HttpBodyType.INPUT_STREAM)) {
      return new InputStreamEntity((InputStream) httpBody.getData(), ContentType.DEFAULT_BINARY);
    }
    throw new IllegalArgumentException("HttpBodyType unimplemented : " + httpBody.getType());
  }
}
