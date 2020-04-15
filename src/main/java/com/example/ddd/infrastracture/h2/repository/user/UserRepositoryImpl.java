package com.example.ddd.infrastracture.h2.repository.user;

import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserIdValue;
import com.example.ddd.domain.model.user.UserRepository;
import com.example.ddd.domain.type.MailAddressValue;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  // TODO 確認：永続化でdomain層のEntityをそのまま利用してよいか？RDBのテーブル構成に沿ったPOJOクラスを作るべきか？

  private final UserMapper userMapper;

  @Override
  public UserEntity findByUserId(UserIdValue userId) {
    return this.userMapper.selectByUserId(userId);
  }

  @Override
  public UserEntity find(MailAddressValue mailAddressValue) {
    return this.userMapper.selectByMailAddress(mailAddressValue);
  }


  @Override
  public UserIdValue nextIdentity() {
    return new UserIdValue(this.userMapper.selectIdentity());
  }

  @Override
  public UserIdValue save(UserEntity userEntity) {
    LocalDateTime now = LocalDateTime.now();
    this.userMapper.insert(userEntity, now);
    return userEntity.getUserId();
  }

}
