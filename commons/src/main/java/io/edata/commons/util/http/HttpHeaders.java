package io.edata.commons.util.http;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpHeaders {

  private Map<String, Object> pairs;
}
