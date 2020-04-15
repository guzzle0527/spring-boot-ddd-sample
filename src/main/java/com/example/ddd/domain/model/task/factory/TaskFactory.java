package com.example.ddd.domain.model.task.factory;

import com.example.ddd.domain.model.task.TaskEntity;
import com.example.ddd.domain.model.task.TaskNameValue;
import com.example.ddd.domain.model.user.UserIdValue;

public interface TaskFactory {

  public TaskEntity createTask(TaskNameValue taskName, UserIdValue userId);

}
