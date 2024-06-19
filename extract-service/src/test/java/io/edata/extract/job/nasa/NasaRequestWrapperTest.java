package io.edata.extract.job.nasa;

import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.edata.commons.enums.nasa.power.DataParameters;
import io.edata.commons.enums.nasa.power.Identifier;
import io.edata.commons.enums.nasa.power.OutputFormat;
import io.edata.commons.enums.nasa.power.TempAverage;
import io.edata.commons.enums.nasa.power.UserCommunity;
import io.edata.commons.util.DateTimeUtils;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled //disable test class from running
class NasaRequestWrapperTest {

  NasaRequestWrapper nasaRequestWrapper;

  @BeforeEach
  void setup() {
    nasaRequestWrapper = new NasaRequestWrapper();
  }


  @Test
  void retrieveTemperature() throws IOException, ParseException {
    String startDate = DateTimeUtils.format(LocalDate.now().minusDays(2), "yyyyMMdd");
    String endDate = DateTimeUtils.format(LocalDate.now(), "yyyyMMdd");
    String lat = "41";
    String lon = "19";
    String bbox = "-40,-70,-38,-66";
    List<PowerTemperature> temperatures = nasaRequestWrapper.retrieveTemperature(
        Identifier.SinglePoint, DataParameters.T2M, startDate, endDate, UserCommunity.SSE,
        TempAverage.DAILY, OutputFormat.JSON, lat, lon, bbox);
    Assertions.assertTrue(CollectionUtils.isNotEmpty(temperatures));
  }

  @Test
  void retrievePressure() throws IOException, ParseException {
    String startDate = DateTimeUtils.format(LocalDate.now().minusDays(2), "yyyyMMdd");
    String endDate = DateTimeUtils.format(LocalDate.now(), "yyyyMMdd");
    String lat = "41";
    String lon = "19";
    String bbox = "-40,-70,-38,-66";
    List<PowerPressure> powerPressures = nasaRequestWrapper.retrievePressure(Identifier.SinglePoint,
        DataParameters.PS, startDate, endDate, UserCommunity.SSE, TempAverage.DAILY,
        OutputFormat.JSON, lat, lon, bbox);
    Assertions.assertTrue(CollectionUtils.isNotEmpty(powerPressures));
  }
}