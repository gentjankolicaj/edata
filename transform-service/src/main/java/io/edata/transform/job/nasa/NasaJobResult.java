package io.edata.transform.job.nasa;

import io.edata.commons.job.result.JobResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NasaJobResult<M, D> extends JobResult<M, D> {

  private M meta;
  private D data;

}
