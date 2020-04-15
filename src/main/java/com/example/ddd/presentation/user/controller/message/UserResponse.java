package com.example.ddd.presentation.user.controller.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse {

  private String id;

  private String name;

  private String gender;

  private String birthDay;

  private String mailAddress;

}
