package io.edata.transform.http;

import io.edata.transform.TransformApplication;
import io.edata.transform.yaml.ApplicationConfigYaml;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalHttpServerTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void start() throws Exception {
    ApplicationConfigYaml applicationConfigYaml = TransformApplication.getConfigurationYaml();
    LocalHttpServer.getInstance().start(applicationConfigYaml.getHttpServer());
  }
}