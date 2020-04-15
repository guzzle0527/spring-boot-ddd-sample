package com.example.ddd.presentation.user.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ddd.application.user.UserUsecase;
import com.example.ddd.application.user.dto.UserInputDto;
import com.example.ddd.application.user.dto.UserOutputDto;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;
import com.example.ddd.presentation.user.controller.message.UserQueryResponse;
import com.example.ddd.presentation.user.controller.message.UserRequest;
import com.example.ddd.presentation.user.controller.message.UserResponse;
import com.example.ddd.presentation.user.controller.presenter.UserPresenter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserUsecase userUsecase;

  @GetMapping("user/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable int id) {
    UserOutputDto userOutputDto = this.userUsecase.findByUserId(id);
    return new ResponseEntity<UserResponse>(UserPresenter.output(userOutputDto), HttpStatus.OK);
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserQueryResponse>> getUsers() {
    List<UserQueryOutputDto> userQueryOutputDtoList = this.userUsecase.findAll();
    return new ResponseEntity<List<UserQueryResponse>>(UserPresenter.output(userQueryOutputDtoList), HttpStatus.OK);
  }

  @PostMapping("user")
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {

    UserInputDto userInputDto = UserInputDto.builder() //
        .firstName(userRequest.getFirstName()) //
        .lastName(userRequest.getLastName()) //
        .gender(userRequest.getGender()) //
        .birthDay(userRequest.getBirthDay()) //
        .mailAddress(userRequest.getMailAddress()) //
        .build();

    UserOutputDto userOutputDto = this.userUsecase.createUser(userInputDto);

    return new ResponseEntity<UserResponse>(UserPresenter.output(userOutputDto), HttpStatus.CREATED);
  }

}
