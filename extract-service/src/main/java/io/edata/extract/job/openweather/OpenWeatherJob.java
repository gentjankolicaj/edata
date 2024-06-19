package io.edata.extract.job.openweather;

import io.edata.commons.job.Job;
import io.edata.extract.yaml.JobConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OpenWeatherJob implements Job<Object> {

  private JobConfigYaml jobYaml;
  private OpenWeatherRequestWrapper openWeatherRequestWrapper;

  @Override
  public Object call() throws Exception {
    return null;
  }
}
