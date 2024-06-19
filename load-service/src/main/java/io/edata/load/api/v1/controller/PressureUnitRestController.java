package io.edata.load.api.v1.controller;

import io.edata.load.dto.PressureUnitDTO;
import io.edata.load.service.PressureUnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PressureUnitRestController.BASE_URL)
public class PressureUnitRestController {

  public final static String BASE_URL = "/api/v1/press-unit/";

  private final PressureUnitService pressureUnitService;

  @Autowired
  public PressureUnitRestController(PressureUnitService pressureUnitService) {
    this.pressureUnitService = pressureUnitService;
  }

  @RequestMapping("")
  public List<PressureUnitDTO> getAllPressureUnits() {
    return pressureUnitService.getAllDTO();
  }
}
