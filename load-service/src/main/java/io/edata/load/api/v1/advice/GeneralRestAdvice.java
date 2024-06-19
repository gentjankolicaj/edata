package io.gentjankolicaj.app.edata.load.api.v1.advice;

import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GeneralRestAdvice {

  @ExceptionHandler(NullIdException.class)
  public ResponseEntity<Object> badId(NullIdException exception) {
    String message = exception.getMessage();
    log.warn(message);
    return new ResponseEntity<Object>(message, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
  }
}
