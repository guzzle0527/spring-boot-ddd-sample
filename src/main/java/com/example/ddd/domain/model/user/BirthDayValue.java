package com.example.ddd.domain.model.user;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.example.ddd.domain.exception.ValidationException;
import lombok.Getter;

public class BirthDayValue {

  @Getter
  private LocalDate value;

  @Deprecated
  BirthDayValue() {
  }

  public BirthDayValue(String value) {
    try {
      LocalDate result = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));

      if(result.isAfter(LocalDate.now())) {
        throw new ValidationException(List.of("生年月日に未来日が設定されています"));
      }

      this.value = result;

    } catch(DateTimeException e) {
      throw new ValidationException(List.of("生年月日に不正な値が設定されています"));
    }
  }

}
