package com.example.ddd.domain.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.ddd.domain.model.user.UserRepository;
import com.example.ddd.domain.service.UserService;
import com.example.ddd.domain.type.MailAddressValue;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public boolean isDeplicated(MailAddressValue mailAddressValue) {
    // メールアドレスの重複は許さない
    return Optional.ofNullable(this.userRepository.find(mailAddressValue)).isPresent();
  }

}
