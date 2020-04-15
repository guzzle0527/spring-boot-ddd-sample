package com.example.ddd.application.user;

import java.util.List;
import com.example.ddd.application.user.dto.UserInputDto;
import com.example.ddd.application.user.dto.UserOutputDto;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;

public interface UserUsecase {

  public UserOutputDto findByUserId(int userId);

  public List<UserQueryOutputDto> findAll();

  public UserOutputDto createUser(UserInputDto userInputDto);

}
