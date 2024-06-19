package io.edata.load.api.v1.controller.nasa.power;

import io.edata.load.dto.nasa.power.PowerPressureDTO;
import io.edata.load.service.nasa.PowerPressureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PowerPressureRestController.BASE_URL)
public class PowerPressureRestController {

  public static final String BASE_URL = "/api/v1/nasa/power/pressure/";

  private final PowerPressureService powerPressureService;

  @Autowired
  public PowerPressureRestController(PowerPressureService powerPressureService) {
    this.powerPressureService = powerPressureService;
  }

  @GetMapping("")
  public List<PowerPressureDTO> getAllPowerPressures() {
    return powerPressureService.getAllDTO();
  }


}
