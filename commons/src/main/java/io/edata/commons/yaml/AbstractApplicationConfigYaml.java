package io.edata.commons.yaml;

public abstract class AbstractApplicationConfigYaml<T extends AbstractJobManagerConfigYaml> {

  public abstract String getName();

  public abstract T getJobManager();
}
