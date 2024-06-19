package io.edata.extract.job.nasa;

import io.edata.commons.domain.PressureUnit;
import io.edata.commons.domain.TemperatureUnit;
import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.edata.commons.enums.nasa.power.DataParameters;
import io.edata.commons.enums.nasa.power.Identifier;
import io.edata.commons.enums.nasa.power.OutputFormat;
import io.edata.commons.enums.nasa.power.TempAverage;
import io.edata.commons.enums.nasa.power.UserCommunity;
import io.edata.commons.util.http.HttpUtils;
import io.edata.commons.validator.UrlParamValidator;
import io.edata.extract.parser.nasa.power.PowerPressureParser;
import io.edata.extract.parser.nasa.power.PowerTemperatureParser;
import io.edata.extract.parser.nasa.power.PowerUrlBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.hc.core5.http.ParseException;

public class NasaRequestWrapper {

  private final PowerUrlBuilder powerUrlBuilder = new PowerUrlBuilder(new UrlParamValidator());

  /**
   * todo : Parser & url builder to be updated because Nasa deprecated API-s. Currently using dummy data
   *
   * @param identifier
   * @param dataParameters
   * @param startDate
   * @param endDate
   * @param userCommunity
   * @param tempAverage
   * @param outputFormat
   * @param lat
   * @param lon
   * @param bbox
   * @return
   * @throws IOException
   * @throws ParseException
   */
  public List<PowerTemperature> retrieveTemperature(
      Identifier identifier, DataParameters dataParameters,
      String startDate, String endDate,
      UserCommunity userCommunity, TempAverage tempAverage,
      OutputFormat outputFormat, String lat, String lon, String bbox)
      throws IOException, ParseException {

    String temperatureUrl = powerUrlBuilder.setIdentifier(identifier)
        .setDataParameters(dataParameters)
        .setStartDate(startDate)
        .setEndDate(endDate)
        .setUserCommunity(userCommunity)
        .setTempAverage(tempAverage)
        .setOutputFormat(outputFormat).
        setLat(lat)
        .setLon(lon)
        .setBbox(bbox).build();
    return PowerTemperatureParser.parseTemperature(HttpUtils.get(temperatureUrl, String.class),
        dataParameters.getValue());

  }

  public List<PowerTemperature> retrieveTemperatureDummy() throws IOException, ParseException {

    return List.of(new PowerTemperature(1L, 30f, new TemperatureUnit("C", "celsius",
            "The degree Celsius is the unit of temperature on the Celsius scale"), LocalDate.now(),
            "json")
        , new PowerTemperature(1L, 30f, new TemperatureUnit("C", "celsius",
            "The degree Celsius is the unit of temperature on the Celsius scale"), LocalDate.now(),
            "json")
        , new PowerTemperature(1L, 30f, new TemperatureUnit("C", "celsius",
            "The degree Celsius is the unit of temperature on the Celsius scale"), LocalDate.now(),
            "json")
        , new PowerTemperature(1L, 30f, new TemperatureUnit("C", "celsius",
            "The degree Celsius is the unit of temperature on the Celsius scale"), LocalDate.now(),
            "json")
        , new PowerTemperature(1L, 30f, new TemperatureUnit("C", "celsius",
            "The degree Celsius is the unit of temperature on the Celsius scale"), LocalDate.now(),
            "json"));

  }

  /**
   * todo : Parser & url builder to be updated because Nasa deprecated API-s. Currently using dummy data
   *
   * @param identifier
   * @param dataParameters
   * @param startDate
   * @param endDate
   * @param userCommunity
   * @param tempAverage
   * @param outputFormat
   * @param lat
   * @param lon
   * @param bbox
   * @return
   * @throws IOException
   * @throws ParseException
   */
  public List<PowerPressure> retrievePressure(Identifier identifier, DataParameters dataParameters,
      String startDate, String endDate,
      UserCommunity userCommunity, TempAverage tempAverage,
      OutputFormat outputFormat, String lat, String lon, String bbox)
      throws IOException, ParseException {

    String pressureUrl = powerUrlBuilder.setIdentifier(identifier)
        .setDataParameters(dataParameters)
        .setStartDate(startDate)
        .setEndDate(endDate)
        .setUserCommunity(userCommunity)
        .setTempAverage(tempAverage)
        .setOutputFormat(outputFormat)
        .setLat(lat)
        .setLon(lon)
        .setBbox(bbox)
        .build();
    return PowerPressureParser.parsePressure(HttpUtils.get(pressureUrl, String.class),
        dataParameters.getValue());

  }

  public List<PowerPressure> retrievePressureDummy() {

    return List.of(new PowerPressure(1L, 30f, new PressureUnit("Pa", "Pascal",
            "The pascal (symbol: Pa) is the unit of pressure in the International System of Units (SI), and is also used to quantify internal pressure, stress, Young's modulus, and ultimate tensile strength. "),
            LocalDate.now(), "json")
        , new PowerPressure(1L, 30f, new PressureUnit("Pa", "Pascal",
            "The pascal (symbol: Pa) is the unit of pressure in the International System of Units (SI), and is also used to quantify internal pressure, stress, Young's modulus, and ultimate tensile strength. "),
            LocalDate.now(), "json")
        , new PowerPressure(1L, 30f, new PressureUnit("Pa", "Pascal",
            "The pascal (symbol: Pa) is the unit of pressure in the International System of Units (SI), and is also used to quantify internal pressure, stress, Young's modulus, and ultimate tensile strength. "),
            LocalDate.now(), "json")
        , new PowerPressure(1L, 30f, new PressureUnit("Pa", "Pascal",
            "The pascal (symbol: Pa) is the unit of pressure in the International System of Units (SI), and is also used to quantify internal pressure, stress, Young's modulus, and ultimate tensile strength. "),
            LocalDate.now(), "json")
        , new PowerPressure(1L, 30f, new PressureUnit("Pa", "Pascal",
            "The pascal (symbol: Pa) is the unit of pressure in the International System of Units (SI), and is also used to quantify internal pressure, stress, Young's modulus, and ultimate tensile strength. "),
            LocalDate.now(), "json"));
  }
}

