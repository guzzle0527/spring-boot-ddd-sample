package com.example.ddd.domain.model.task;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.example.ddd.domain.exception.Validator;
import lombok.Getter;

public class TaskNameValue {

  @Getter
  @NotEmpty(message = "タスク名は必須です")
  @Size(max = 100, message = "タスク名は{max}文字以下で設定してください")
  private String value;

  @Deprecated
  TaskNameValue() {
  }

  public TaskNameValue(String value) {
    this.value = value;
    Validator.validate(this);
  }


}
