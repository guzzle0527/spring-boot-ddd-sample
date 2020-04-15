package com.example.ddd.domain.model.user;

import lombok.Getter;

public class UserIdValue {

  @Getter
  private int value;

  @Deprecated
  UserIdValue() {
  }

  public UserIdValue(int value) {
    this.value = value;
  }

}
