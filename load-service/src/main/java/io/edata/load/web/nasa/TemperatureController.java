package io.edata.load.web.nasa;

import io.edata.load.service.InformationService;
import io.edata.load.service.nasa.PowerTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(TemperatureController.BASE_URL)
public class TemperatureController {

  public static final String BASE_URL = "/nasa/temperature/";

  private final PowerTemperatureService powerTemperatureService;
  private final InformationService informationService;

  @Autowired
  public TemperatureController(PowerTemperatureService powerTemperatureService,
      InformationService informationService) {
    this.powerTemperatureService = powerTemperatureService;
    this.informationService = informationService;
  }
}
