package io.gentjankolicaj.app.edata.load.api.v1.controller.nasa.power;

import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerTemperatureDTO;
import io.gentjankolicaj.app.edata.load.service.nasa.PowerTemperatureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PowerTemperatureRestController.BASE_URL)
public class PowerTemperatureRestController {

  public static final String BASE_URL = "/api/v1/nasa/power/temperature/";

  private final PowerTemperatureService powerTemperatureService;

  @Autowired
  public PowerTemperatureRestController(PowerTemperatureService powerTemperatureService) {
    this.powerTemperatureService = powerTemperatureService;
  }

  @GetMapping("")
  public List<PowerTemperatureDTO> getAllPowerTemperatures() {
    return powerTemperatureService.getAllDTO();
  }

}
