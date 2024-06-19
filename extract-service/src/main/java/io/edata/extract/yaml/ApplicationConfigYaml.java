package io.edata.extract.yaml;

import io.edata.commons.yaml.AbstractApplicationConfigYaml;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApplicationConfigYaml extends AbstractApplicationConfigYaml<JobManagerConfigYaml> {

  private String name;
  private JobManagerConfigYaml jobManager;


  @Override
  public String getName() {
    return name;
  }

  @Override
  public JobManagerConfigYaml getJobManager() {
    return jobManager;
  }
}
