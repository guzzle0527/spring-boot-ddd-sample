package com.example.ddd.presentation.user.controller.message;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserQueryResponse {

  private String userId;

  private String firstName;

  private String lastName;

  private String gender;

  private String birthDay;

  private String mailAddress;

  List<TaskResponse> taskList;

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  public class TaskResponse {

    private String taskId;

    private String taskName;
  }

}
