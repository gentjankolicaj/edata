package io.edata.extract.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiProviderConfigYaml {

  private String name;
  private String apiKey;
  private String user;
  private String baseUrl;
}
