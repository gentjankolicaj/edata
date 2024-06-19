package io.edata.load.api.v1.advice;


import io.edata.load.exception.api.request.UserBadRequestException;
import io.edata.load.exception.api.uri.UserBadUriException;
import io.edata.load.exception.resource.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestAdvice {


  @ExceptionHandler(UserBadRequestException.class)
  public ResponseEntity<Object> badRequest(UserBadRequestException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserBadUriException.class)
  public ResponseEntity<Object> badUri(UserBadUriException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> notFound(UserNotFoundException exception) {
    String message = exception.getMessage();
    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
