package com.example.ddd.application.user.dto;

import java.time.LocalDate;
import com.example.ddd.domain.model.user.UserEntity;
import lombok.Getter;

@Getter
public class UserOutputDto {

  private int id;

  private String firstName;

  private String lastName;

  private String gender;

  private LocalDate birthDay;

  private String mailAddress;

  public UserOutputDto(UserEntity userEntity) {
    this.id = userEntity.getUserId().getValue();
    this.firstName = userEntity.getUserName().getFirstName();
    this.lastName = userEntity.getUserName().getLastName();
    this.gender = userEntity.getGender().getGender().getLabel();
    this.birthDay = userEntity.getBirthDay().getValue();
    this.mailAddress = userEntity.getMailAddress().getValue();
  }

}
