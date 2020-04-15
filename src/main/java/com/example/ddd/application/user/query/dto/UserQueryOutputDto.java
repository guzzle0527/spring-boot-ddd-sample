package com.example.ddd.application.user.query.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserQueryOutputDto {

  private int id;

  private String firstName;

  private String lastName;

  private String gender;

  private LocalDate birthDay;

  private String mailAddress;

  private int taskId;

  private String taskName;

}
