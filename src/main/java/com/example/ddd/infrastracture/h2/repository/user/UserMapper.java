package com.example.ddd.infrastracture.h2.repository.user;

import java.time.LocalDateTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserIdValue;
import com.example.ddd.domain.type.MailAddressValue;

@Mapper
interface UserMapper {

  UserEntity selectByUserId(@Param("userId") UserIdValue userId);

  UserEntity selectByMailAddress(@Param("mailAddress") MailAddressValue mailAddressValue);

  int selectIdentity();

  int insert(@Param("user") UserEntity userEntity, @Param("now") LocalDateTime now);

}
