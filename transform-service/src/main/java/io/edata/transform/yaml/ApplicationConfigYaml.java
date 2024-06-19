package io.edata.transform.yaml;

import io.edata.commons.yaml.AbstractApplicationConfigYaml;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ApplicationConfigYaml extends AbstractApplicationConfigYaml<JobManagerConfigYaml> {

  private String name;
  private HttpServerConfigYaml httpServer;
  private List<CacheConfigYaml> caches;
  private JobManagerConfigYaml jobManager;
  private RedisConfigYml redis;

}
