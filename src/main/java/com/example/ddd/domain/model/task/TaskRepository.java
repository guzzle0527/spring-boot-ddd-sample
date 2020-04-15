package com.example.ddd.domain.model.task;

import com.example.ddd.domain.model.user.UserIdValue;

public interface TaskRepository {

  public TaskIdValue nextIdentity();

  public TaskIdValue save(TaskEntity taskEntity);

  public int countByUser(UserIdValue userId);

}
