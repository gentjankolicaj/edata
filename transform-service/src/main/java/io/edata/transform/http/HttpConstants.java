package io.edata.transform.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HttpConstants {

  CACHE_HEADER("X-CACHE-KEY");

  private final String value;
}
