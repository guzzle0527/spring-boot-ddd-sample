package com.example.ddd.application.task.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.ddd.application.task.TaskUsecase;
import com.example.ddd.application.task.dto.TaskInputDto;
import com.example.ddd.domain.exception.ValidationException;
import com.example.ddd.domain.model.task.TaskEntity;
import com.example.ddd.domain.model.task.TaskIdValue;
import com.example.ddd.domain.model.task.TaskNameValue;
import com.example.ddd.domain.model.task.TaskRepository;
import com.example.ddd.domain.model.task.factory.TaskFactory;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserIdValue;
import com.example.ddd.domain.model.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskUsecaseImpl implements TaskUsecase {

  private final UserRepository userRepository;

  private final TaskFactory taskFactory;

  private final TaskRepository taskRepository;


  @Override
  public int createTask(TaskInputDto taskInputDto) {
    UserIdValue userId = new UserIdValue(taskInputDto.getUserId());
    Optional<UserEntity> userEntity = Optional.ofNullable(this.userRepository.findByUserId(userId));

    if(!userEntity.isPresent()) {
      throw new ValidationException(List.of("対象ユーザが存在しません"));
    }

    TaskNameValue taskName = new TaskNameValue(taskInputDto.getTaskName());
    TaskEntity taskEntity = userEntity.get().createTask(this.taskFactory, taskName);

    TaskIdValue taskId =  this.taskRepository.save(taskEntity);
    return taskId.getValue();
  }

}
