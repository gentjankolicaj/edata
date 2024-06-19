package io.gentjankolicaj.app.edata.load.web;


import io.gentjankolicaj.app.edata.load.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HomeController.BASE_URL)
public class HomeController {

  public static final String BASE_URL = "/";

  private final InformationService informationService;

  @Autowired
  public HomeController(InformationService informationService) {
    this.informationService = informationService;
  }

  @RequestMapping("")
  public String showRoot() {
    return "core/index";
  }


  @RequestMapping("home")
  public String showIndex() {
    return "core/index";
  }

  @RequestMapping("home/")
  public String showIndex2() {
    return "core/index";
  }


}
