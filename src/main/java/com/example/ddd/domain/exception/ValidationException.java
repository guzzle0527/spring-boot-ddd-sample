package com.example.ddd.domain.exception;

import java.util.List;
import lombok.Getter;

public class ValidationException extends RuntimeException {

  @Getter
  private List<String> errMsgList;

  public ValidationException(List<String> errMsgList) {
    this.errMsgList = errMsgList;
  }

}
