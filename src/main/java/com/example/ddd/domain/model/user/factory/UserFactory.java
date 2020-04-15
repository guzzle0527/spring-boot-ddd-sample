package com.example.ddd.domain.model.user.factory;

import com.example.ddd.domain.model.user.BirthDayValue;
import com.example.ddd.domain.model.user.UserEntity;
import com.example.ddd.domain.model.user.UserNameValue;
import com.example.ddd.domain.type.GenderValue;
import com.example.ddd.domain.type.MailAddressValue;

public interface UserFactory {

  public UserEntity createUser(UserNameValue userName, GenderValue gender, BirthDayValue birthDay, MailAddressValue mailAddress);

}
