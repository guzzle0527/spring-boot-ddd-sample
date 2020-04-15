package com.example.ddd.domain.model.user;

import com.example.ddd.domain.type.MailAddressValue;

public interface UserRepository {

  public UserEntity findByUserId(UserIdValue userId);

  public UserEntity find(MailAddressValue mailAddress);

  public UserIdValue nextIdentity();

  public UserIdValue save(UserEntity userEntity);
}
