package com.example.ddd.application.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInputDto {

  private String firstName;

  private String lastName;

  private String gender;

  private String birthDay;

  private String mailAddress;

}
