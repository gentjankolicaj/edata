package io.edata.extract.yaml;

import io.edata.commons.yaml.AbstractJobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobConfigYaml extends AbstractJobConfigYaml {

  private String name;
  private int sleep;
  private int failedAttemptMax;
  private ApiProviderConfigYaml apiProvider;
  private ExternalServerConfigYaml externalServer;
}
