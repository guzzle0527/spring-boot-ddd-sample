package com.example.ddd.domain.model.user;

import com.example.ddd.domain.model.task.TaskEntity;
import com.example.ddd.domain.model.task.TaskNameValue;
import com.example.ddd.domain.model.task.factory.TaskFactory;
import com.example.ddd.domain.type.GenderValue;
import com.example.ddd.domain.type.MailAddressValue;
import lombok.Getter;

@Getter
public class UserEntity {

  private UserIdValue userId;

  private UserNameValue userName;

  private GenderValue gender;

  private BirthDayValue birthDay;

  private MailAddressValue mailAddress;

  @Deprecated
  UserEntity() {
  }

  public UserEntity(UserIdValue userId, UserNameValue userName, GenderValue gender, BirthDayValue birthDay, MailAddressValue mailAddress) {
    this.userId = userId;
    this.userName = userName;
    this.gender = gender;
    this.birthDay = birthDay;
    this.mailAddress = mailAddress;
  }

  public TaskEntity createTask(TaskFactory taskFactory, TaskNameValue taskName) {
    return taskFactory.createTask(taskName, this.userId);
  }

}
