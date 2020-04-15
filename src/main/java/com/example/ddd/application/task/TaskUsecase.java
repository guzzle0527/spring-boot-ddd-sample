package com.example.ddd.application.task;

import com.example.ddd.application.task.dto.TaskInputDto;

public interface TaskUsecase {

  public int createTask(TaskInputDto taskInputDto);

}
