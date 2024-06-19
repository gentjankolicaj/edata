package io.edata.load.api.v1.advice;

import io.edata.load.exception.api.request.CountryBadRequestException;
import io.edata.load.exception.api.uri.CountryBadUriException;
import io.edata.load.exception.resource.CountryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CountryRestAdvice {


  @ExceptionHandler(CountryBadRequestException.class)
  public ResponseEntity<Object> badRequest(CountryBadRequestException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<Object>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(CountryBadUriException.class)
  public ResponseEntity<Object> badUri(CountryBadUriException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<Object>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(CountryNotFoundException.class)
  public ResponseEntity<Object> notFound(CountryNotFoundException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.NOT_FOUND);

  }
}
