package io.edata.transform;

import io.edata.commons.job.Job;
import io.edata.commons.util.YamlUtils;
import io.edata.transform.cache.LocalCachePool;
import io.edata.transform.http.LocalHttpServer;
import io.edata.transform.job.JobConstants;
import io.edata.transform.job.JobManager;
import io.edata.transform.job.nasa.NasaJob;
import io.edata.transform.redis.RedisManager;
import io.edata.transform.yaml.ApplicationConfigYaml;
import io.edata.transform.yaml.JobConfigYaml;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

/**
 * Hello world!
 */
@Slf4j
public class TransformApplication {

  public static void main(String[] args) throws Exception {
    ApplicationConfigYaml applicationConfigYaml = getConfigurationYaml();
    LocalCachePool.getInstance().initCaches(applicationConfigYaml.getCaches());
    RedisManager.getInstance().initClient(applicationConfigYaml.getRedis());
    LocalHttpServer.getInstance().start(applicationConfigYaml.getHttpServer());
    (new JobManager(applicationConfigYaml)).runJobs(getJobsImpl(applicationConfigYaml));
  }

  public static ApplicationConfigYaml getConfigurationYaml() throws IOException {
    ApplicationConfigYaml applicationConfigYaml = YamlUtils.read("application.yml",
        ApplicationConfigYaml.class);
    log.info("{}", applicationConfigYaml);
    return applicationConfigYaml;
  }

  static List<Job> getJobsImpl(ApplicationConfigYaml applicationConfigYaml) {
    if (CollectionUtils.isNotEmpty(applicationConfigYaml.getJobManager().getJobs())) {
      List<JobConfigYaml> jobConfigYamls = applicationConfigYaml.getJobManager().getJobs();
      return List.of(new NasaJob(jobConfigYamls.stream()
          .filter(e -> e.getName().equalsIgnoreCase(JobConstants.NASA_JOB_NAME)).findAny().get()));

    } else {
      return List.of();
    }
  }
}
