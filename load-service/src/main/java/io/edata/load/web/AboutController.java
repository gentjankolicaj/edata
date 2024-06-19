package io.edata.load.web;

import io.edata.load.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(AboutController.BASE_URL)
public class AboutController {

  public static final String BASE_URL = "/about";

  private final InformationService informationService;

  @Autowired
  public AboutController(InformationService informationService) {
    this.informationService = informationService;
  }

  @RequestMapping("")
  public String showAbout() {
    return "core/about";
  }

  @RequestMapping("/")
  public String showAbout2() {
    return "core/about";
  }
}
