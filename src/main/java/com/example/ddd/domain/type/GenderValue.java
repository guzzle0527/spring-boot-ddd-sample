package com.example.ddd.domain.type;

import java.util.List;
import java.util.stream.Stream;
import com.example.ddd.domain.exception.ValidationException;
import lombok.Getter;

public class GenderValue {

  @Getter
  private String value;

  @Deprecated
  GenderValue() {
  }

  public GenderValue(String value) {
    this.value = value;
    this.getGender();
  }

  public Gender getGender() {
    return Stream.of(Gender.values())
        .filter(x -> x.value.equals(value))
        .findFirst()
        .orElseThrow(() -> new ValidationException(List.of("性別の設定が不正です")));
  }

  public enum Gender {
    MAN("男性", "1"),
    WOMAN("女性", "2"),
    UNIDENTIFIED("不明", "9"),
    ;

    @Getter
    private String label;

    @Getter
    private String value;

    private Gender(String label, String value) {
      this.label = label;
      this.value = value;
    }

  }

}
