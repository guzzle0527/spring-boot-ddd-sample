package com.example.ddd.presentation.user.controller.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {

  private String firstName;

  private String lastName;

  private String gender;

  private String birthDay;

  private String mailAddress;

}
