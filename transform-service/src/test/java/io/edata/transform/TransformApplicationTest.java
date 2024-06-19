package io.edata.transform;

import static java.util.Objects.nonNull;

import io.edata.transform.yaml.ApplicationConfigYaml;
import java.io.IOException;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransformApplicationTest {

  @Test
  void getConfigurationYaml() throws IOException {
    ApplicationConfigYaml applicationConfigYaml = TransformApplication.getConfigurationYaml();
    Assertions.assertTrue(nonNull(applicationConfigYaml));
    Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
    Assertions.assertTrue(
        CollectionUtils.isNotEmpty(applicationConfigYaml.getJobManager().getJobs()));
    Assertions.assertTrue(
        CollectionUtils.isNotEmpty(applicationConfigYaml.getHttpServer().getPaths()));
    Assertions.assertTrue(nonNull(applicationConfigYaml.getRedis()));
  }
}