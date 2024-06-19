package io.edata.load.api.v1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralRestController.BASE_URL)
public class GeneralRestController {

  public static final String BASE_URL = "/api/v1";


  public GeneralRestController() {
  }


  @RequestMapping("*")
  public ResponseEntity<Object> otherNotMappedRequests() {
    return new ResponseEntity<>("Wrong uri", new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }


}
