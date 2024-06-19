package io.edata.load.web;

import io.edata.load.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ContactController.BASE_URL)
public class ContactController {

  public static final String BASE_URL = "/contact";


  private final InformationService informationService;

  @Autowired
  public ContactController(InformationService informationService) {
    this.informationService = informationService;
  }

  @RequestMapping("")
  public String showContact() {
    return "core/contact";
  }

  @RequestMapping("/")
  public String showContact2() {
    return "core/contact";
  }

}
