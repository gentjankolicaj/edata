package io.edata.load.api.v1.controller;

import io.edata.load.dto.TemperatureUnitDTO;
import io.edata.load.service.TemperatureUnitService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TemperatureUnitRestController.BASE_URL)
public class TemperatureUnitRestController {

  public final static String BASE_URL = "/api/v1/temp-unit/";

  private final TemperatureUnitService temperatureUnitService;

  public TemperatureUnitRestController(TemperatureUnitService temperatureUnitService) {
    this.temperatureUnitService = temperatureUnitService;
  }

  @RequestMapping("")
  public List<TemperatureUnitDTO> getAllTemperatureUnits() {
    return temperatureUnitService.getAllDTO();
  }
}
