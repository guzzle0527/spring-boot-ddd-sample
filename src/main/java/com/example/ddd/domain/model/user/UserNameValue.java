package com.example.ddd.domain.model.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.example.ddd.domain.exception.Validator;
import lombok.Getter;

public class UserNameValue {

  @Getter
  @NotEmpty(message = "名は必須です")
  @Size(max = 50, message = "名は{max}文字以下で設定してください")
  private String firstName;

  @Getter
  @NotEmpty(message = "姓は必須です")
  @Size(max = 50, message="姓は{max}文字以下で設定してください")
  private String lastName;

  @Deprecated
  UserNameValue() {
  }

  public UserNameValue(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    Validator.validate(this);
  }

}
