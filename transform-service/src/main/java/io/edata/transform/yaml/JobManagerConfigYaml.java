package io.edata.transform.yaml;

import io.edata.commons.yaml.AbstractJobManagerConfigYaml;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class JobManagerConfigYaml extends AbstractJobManagerConfigYaml<JobConfigYaml> {

  private int threadPoolSize;
  private List<JobConfigYaml> jobs;

}
