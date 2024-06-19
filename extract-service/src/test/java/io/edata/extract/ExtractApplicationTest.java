package io.edata.extract;


import io.edata.commons.job.Job;
import io.edata.extract.yaml.ApplicationConfigYaml;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@Slf4j
public class ExtractApplicationTest {


  @Test
  void getConfiguration() throws IOException {
    ApplicationConfigYaml applicationYaml = ExtractApplication.getConfigurationYaml();
    log.info("ExtractApplication yaml {}", applicationYaml);
  }

  @Test
  void getJobsImpl() throws IOException {
    ApplicationConfigYaml applicationYaml = ExtractApplication.getConfigurationYaml();
    List<Job> jobs = ExtractApplication.getJobsImpl(applicationYaml.getJobManager().getJobs());
    Assertions.assertTrue(CollectionUtils.isNotEmpty(jobs));
  }
}
