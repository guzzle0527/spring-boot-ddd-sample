package com.example.ddd.domain.model.task;

import lombok.Getter;

public class TaskIdValue {

  @Getter
  private int value;

  @Deprecated
  TaskIdValue() {
  }

  public TaskIdValue(int value) {
    this.value = value;
  }

}
