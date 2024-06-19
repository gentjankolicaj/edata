package io.edata.transform.job;

import io.edata.commons.job.AbstractJobManager;
import io.edata.commons.job.Job;
import io.edata.transform.yaml.ApplicationConfigYaml;
import io.edata.transform.yaml.JobManagerConfigYaml;
import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;

public class JobManager extends AbstractJobManager<JobManagerConfigYaml> {

  public JobManager(ApplicationConfigYaml applicationConfigYaml) {
    super(applicationConfigYaml.getJobManager());
  }

  @Override
  public void runJobs(Job... jobs) {
    for (Job job : jobs) {
      executorService.submit(job);
    }
  }

  @Override
  public void runJobs(Collection<Job> jobs) {
    if (CollectionUtils.isNotEmpty(jobs)) {
      for (Job job : jobs) {
        executorService.submit(job);
      }
    }
  }
}
