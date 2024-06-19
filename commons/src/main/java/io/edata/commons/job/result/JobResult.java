package io.edata.commons.job.result;


public abstract class JobResult<M, D> {

  public abstract M getMeta();

  public abstract D getData();
}
