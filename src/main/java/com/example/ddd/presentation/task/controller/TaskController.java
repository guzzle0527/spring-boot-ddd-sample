package com.example.ddd.presentation.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ddd.application.task.TaskUsecase;
import com.example.ddd.application.task.dto.TaskInputDto;
import com.example.ddd.presentation.task.controller.message.TaskRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TaskController {

  private final TaskUsecase taskUsecase;

  @PostMapping("task")
  public ResponseEntity<Integer> createTask(@RequestBody TaskRequest taskRequest) {
    TaskInputDto taskInputDto = TaskInputDto.builder() //
        .taskName(taskRequest.getTaskName()) //
        .userId(taskRequest.getUserId()) //
        .build();
    int taskId = this.taskUsecase.createTask(taskInputDto);
    return new ResponseEntity<Integer>(taskId, HttpStatus.CREATED);
  }

}
