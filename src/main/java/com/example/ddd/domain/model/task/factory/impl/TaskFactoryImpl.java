package com.example.ddd.domain.model.task.factory.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ddd.domain.exception.ValidationException;
import com.example.ddd.domain.model.task.TaskEntity;
import com.example.ddd.domain.model.task.TaskIdValue;
import com.example.ddd.domain.model.task.TaskNameValue;
import com.example.ddd.domain.model.task.TaskRepository;
import com.example.ddd.domain.model.task.factory.TaskFactory;
import com.example.ddd.domain.model.user.UserIdValue;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskFactoryImpl implements TaskFactory {

  private final TaskRepository taskRepository;

  @Override
  public TaskEntity createTask(TaskNameValue taskName, UserIdValue userId) {

    // TODO 確認：Factoryでこの仕様を実現してよいのか
    if(this.taskRepository.countByUser(userId) >= 10) {
      throw new ValidationException(List.of("タスク登録の上限を超えています"));
    }

    TaskIdValue taskId = this.taskRepository.nextIdentity();
    return new TaskEntity(taskId, taskName, userId);
  }

}
