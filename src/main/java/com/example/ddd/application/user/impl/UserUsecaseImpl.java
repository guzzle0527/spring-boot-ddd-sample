package com.example.ddd.application.user.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ddd.application.user.UserUsecase;
import com.example.ddd.application.user.dto.UserInputDto;
import com.example.ddd.application.user.dto.UserOutputDto;
import com.example.ddd.application.user.query.UserQueryService;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;
import com.example.ddd.domain.exception.ValidationException;
import com.example.ddd.domain.model.user.BirthDayValue;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserIdValue;
import com.example.ddd.domain.model.user.UserNameValue;
import com.example.ddd.domain.model.user.UserRepository;
import com.example.ddd.domain.model.user.factory.UserFactory;
import com.example.ddd.domain.type.GenderValue;
import com.example.ddd.domain.type.MailAddressValue;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserUsecaseImpl implements UserUsecase {

  private final UserFactory userFactory;

  private final UserRepository userRepository;

  private final UserQueryService userQuerySerivce;

  @Override
  public UserOutputDto findByUserId(int userId) {
    UserEntity userEntity = Optional.ofNullable(this.userRepository
        .findByUserId(new UserIdValue(userId)))
        .orElseThrow(() -> new ValidationException(List.of("該当のユーザは存在しません")));
    return new UserOutputDto(userEntity);
  }

  @Override
  public List<UserQueryOutputDto> findAll() {
    return this.userQuerySerivce.findAll();
  }

  @Override
  @Transactional(readOnly = false)
  public UserOutputDto createUser(UserInputDto userInputDto) {
    UserNameValue userName = new UserNameValue(userInputDto.getFirstName(), userInputDto.getLastName());
    GenderValue gender = new GenderValue(userInputDto.getGender());
    BirthDayValue birthDay = new BirthDayValue(userInputDto.getBirthDay());
    MailAddressValue mailAddress = new MailAddressValue(userInputDto.getMailAddress());

    UserEntity userEntity = this.userFactory.createUser(userName, gender, birthDay, mailAddress);

    this.userRepository.save(userEntity);

    return this.findByUserId(userEntity.getUserId().getValue());
  }

}
