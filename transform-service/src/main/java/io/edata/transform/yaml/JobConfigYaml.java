package io.edata.transform.yaml;

import io.edata.commons.yaml.AbstractJobConfigYaml;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class JobConfigYaml extends AbstractJobConfigYaml {

  private String name;
  private int sleep;
  private int failedAttemptMax;
  private List<String> cacheKeys;


}
