package io.edata.commons.util.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpBodyType {

  TEXT("text", 0), FORM_DATA("form-data", 1), X_WWW_FORM_URLENCODED("x-www-form-urlencoded", 2),
  BINARY("binary", 3), HTML("html", 4), JSON("json", 5), XML("xml", 6),
  INPUT_STREAM("input-stream", 7), FILE("file", 8);

  private final String name;
  private final int index;
}
