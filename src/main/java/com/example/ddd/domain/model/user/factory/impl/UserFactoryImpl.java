package com.example.ddd.domain.model.user.factory.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.ddd.domain.exception.ValidationException;
import com.example.ddd.domain.model.user.BirthDayValue;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserIdValue;
import com.example.ddd.domain.model.user.UserNameValue;
import com.example.ddd.domain.model.user.UserRepository;
import com.example.ddd.domain.model.user.factory.UserFactory;
import com.example.ddd.domain.service.UserService;
import com.example.ddd.domain.type.GenderValue;
import com.example.ddd.domain.type.MailAddressValue;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserFactoryImpl implements UserFactory {

  private final UserService userService;

  private final UserRepository userRepository;


  @Override
  public UserEntity createUser(UserNameValue userName, GenderValue gender, BirthDayValue birthDay,
      MailAddressValue mailAddress) {

    if(this.userService.isDeplicated(mailAddress)) {
      throw new ValidationException(List.of("メールアドレスがすでに登録されています"));
    }

    UserIdValue userId = this.userRepository.nextIdentity();
    UserEntity userEntity = new UserEntity(userId, userName, gender, birthDay, mailAddress);

    return userEntity;
  }

}
