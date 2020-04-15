package com.example.ddd.domain.model.task;

import com.example.ddd.domain.model.user.UserIdValue;
import lombok.Getter;

@Getter
public class TaskEntity {

  private TaskIdValue taskId;

  private TaskNameValue taskName;

  private UserIdValue userId;

  @Deprecated
  TaskEntity() {
  }

  public TaskEntity(TaskIdValue taskId, TaskNameValue taskName, UserIdValue userId) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.userId = userId;
  }

}
