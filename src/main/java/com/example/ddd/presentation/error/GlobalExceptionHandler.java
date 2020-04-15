package com.example.ddd.presentation.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.ddd.domain.exception.ValidationException;
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<GlobalErrorResponse>  handleValidationException(ValidationException e) {
    GlobalErrorResponse response = GlobalErrorResponse.builder().errors(e.getErrMsgList()).build();
    return new ResponseEntity<GlobalErrorResponse>(response, HttpStatus.BAD_REQUEST);
  }

}
