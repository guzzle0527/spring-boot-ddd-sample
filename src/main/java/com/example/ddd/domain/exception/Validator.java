package com.example.ddd.domain.exception;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

public class Validator {

  public static <T> void validate(T target) {
    Set<ConstraintViolation<T>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(target);

    if(violations.size() > 0) {
      List<String> list = violations.stream().map(x -> {
        return x.getMessage();
      }).collect(Collectors.toList());
      throw new ValidationException(list);
    }
  }


}
