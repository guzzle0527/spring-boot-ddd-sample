package com.example.ddd.domain.type;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import com.example.ddd.domain.exception.Validator;
import lombok.Getter;

public class MailAddressValue {

  @Getter
  @Email(message = "メールアドレスが不正です")
  @Size(max = 300, message = "メールアドレスは最大{max}文字までです")
  private String value;

  @Deprecated
  MailAddressValue() {
  }

  public MailAddressValue(String value) {
    this.value = value;
    Validator.validate(this);
  }


}
