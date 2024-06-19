package io.edata.extract.job.nasa;

import io.edata.extract.yaml.ApiProviderConfigYaml;
import io.edata.extract.yaml.ExternalServerConfigYaml;
import io.edata.extract.yaml.HttpPathConfigYaml;
import io.edata.extract.yaml.JobConfigYaml;
import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class NasaJobTest {

  NasaJob nasaJob;
  NasaRequestWrapper nasaRequestWrapper;

  @BeforeEach
  void setup() {
    nasaRequestWrapper = new NasaRequestWrapper();
    nasaJob = new NasaJob(new JobConfigYaml("nasa-job", 2000, 5,
        new ApiProviderConfigYaml("nasa", "no-api-key", "anonymous", "none"),
        new ExternalServerConfigYaml("transform-server", "http://localhost:9000",
            List.of(new HttpPathConfigYaml("/api/v1/nasa", "POST")))), nasaRequestWrapper);
  }

  @Test
  void call() {
  }

  @Disabled
  @Test
  void sentRequest() throws IOException, ParseException {
    ExternalServerConfigYaml externalServerConfigYaml = nasaJob.getJobYaml().getExternalServer();
    nasaJob.sentTemperatureRequest(externalServerConfigYaml,
        nasaRequestWrapper.retrieveTemperatureDummy());
    nasaJob.sentPressureRequest(externalServerConfigYaml,
        nasaRequestWrapper.retrievePressureDummy());
  }
}