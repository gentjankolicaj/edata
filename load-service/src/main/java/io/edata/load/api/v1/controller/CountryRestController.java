package io.edata.load.api.v1.controller;


import io.edata.load.dto.CountryDTO;
import io.edata.load.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CountryRestController.BASE_URI)
public class CountryRestController {

  public static final String BASE_URI = "/api/v1/countries/";

  private final CountryService countryService;

  @Autowired
  public CountryRestController(CountryService countryService) {
    this.countryService = countryService;
  }


  @ResponseStatus(HttpStatus.OK)
  @GetMapping("")
  public List<CountryDTO> getAllCountries() {
    return countryService.getAllDTO();
  }


  @ResponseStatus(HttpStatus.OK)
  @GetMapping("{countryName}")
  public CountryDTO getCountryById(@PathVariable("countryName") String countryName) {
    return countryService.getByIdDTO(countryName);
  }


  @RequestMapping("*")
  public ResponseEntity<Object> otherNotMappedRequests() {
    return new ResponseEntity<>("Wrong uri", new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

}
