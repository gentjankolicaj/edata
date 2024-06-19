package io.edata.extract.yaml;

import io.edata.commons.yaml.AbstractJobManagerConfigYaml;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class JobManagerConfigYaml extends AbstractJobManagerConfigYaml<JobConfigYaml> {

  private int threadPoolSize;
  private List<JobConfigYaml> jobs;

  @Override
  public int getThreadPoolSize() {
    return threadPoolSize;
  }

  @Override
  public List<JobConfigYaml> getJobs() {
    return jobs;
  }
}
