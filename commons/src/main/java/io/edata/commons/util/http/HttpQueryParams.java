package io.edata.commons.util.http;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpQueryParams {

  private Map<String, Object> pairs;
}
