package io.gentjankolicaj.app.edata.load.web;

import io.gentjankolicaj.app.edata.load.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HelpController.BASE_URL)
public class HelpController {

  public static final String BASE_URL = "/help";

  private final InformationService informationService;

  @Autowired
  public HelpController(InformationService informationService) {
    this.informationService = informationService;
  }

  @RequestMapping("")
  public String showHelp() {
    return "core/help";
  }

  @RequestMapping("/")
  public String showHelp2() {
    return "core/help";
  }
}
