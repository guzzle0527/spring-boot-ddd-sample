package com.example.ddd.infrastracture.h2.repository.task;

import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import com.example.ddd.domain.model.task.TaskEntity;
import com.example.ddd.domain.model.task.TaskIdValue;
import com.example.ddd.domain.model.task.TaskRepository;
import com.example.ddd.domain.model.user.UserIdValue;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

  private final TaskMapper taskMapper;

  @Override
  public TaskIdValue nextIdentity() {
    return new TaskIdValue(this.taskMapper.selectIdentity());
  }

  @Override
  public TaskIdValue save(TaskEntity taskEntity) {
    LocalDateTime now = LocalDateTime.now();
    this.taskMapper.insert(taskEntity, now);
    return taskEntity.getTaskId();
  }

  @Override
  public int countByUser(UserIdValue userId) {
    return this.taskMapper.selectCountByUserId(userId.getValue());
  }

}
