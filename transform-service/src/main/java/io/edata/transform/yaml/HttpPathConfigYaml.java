package io.edata.transform.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class HttpPathConfigYaml {

  private String path;
  private String method;
  private String cacheKey;
}
