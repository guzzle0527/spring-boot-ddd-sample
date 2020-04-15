package com.example.ddd.presentation.user.controller.presenter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.ddd.application.user.dto.UserOutputDto;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;
import com.example.ddd.presentation.user.controller.message.UserQueryResponse;
import com.example.ddd.presentation.user.controller.message.UserQueryResponse.TaskResponse;
import com.example.ddd.presentation.user.controller.message.UserResponse;

public class UserPresenter {

  public static UserResponse output(UserOutputDto userOutputDto) {
   return UserResponse.builder()
       .id(String.valueOf(userOutputDto.getId()))
       .name(String.format("%s %s", userOutputDto.getFirstName(), userOutputDto.getLastName())) //
       .gender(userOutputDto.getGender()) //
       .birthDay(userOutputDto.getBirthDay().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))) //
       .mailAddress(userOutputDto.getMailAddress()) //
       .build();
  }

  public static List<UserQueryResponse> output(List<UserQueryOutputDto> userQueryOutputDtoList) {

    List<UserQueryResponse> list = new ArrayList<>();

    List<Integer> userIdList = userQueryOutputDtoList.stream().map(x -> {
      return x.getId();
    }).distinct().collect(Collectors.toList());

    for(Integer userId : userIdList) {
      UserQueryResponse userQueryReponse = userQueryOutputDtoList.stream().filter(x -> x.getId() == userId).findFirst().map(userInfo -> {
        return UserQueryResponse.builder()
            .userId(String.valueOf(userInfo.getId())) //
            .firstName(String.valueOf(userInfo.getFirstName())) //
            .lastName(String.valueOf(userInfo.getLastName())) //
            .gender(userInfo.getGender())
            .birthDay(userInfo.getBirthDay().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))) //
            .mailAddress(userInfo.getMailAddress()) //
            .build();
      }).get();

      List<TaskResponse> taskResponseList = userQueryOutputDtoList.stream().filter(x -> x.getId() == userId).map(x -> {
        return userQueryReponse.new TaskResponse(String.valueOf(x.getTaskId()), x.getTaskName());
      }).collect(Collectors.toList());

      userQueryReponse.setTaskList(taskResponseList);
      list.add(userQueryReponse);

    }

    return list;
  }

}
