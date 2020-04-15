package com.example.ddd.domain.service;

import com.example.ddd.domain.type.MailAddressValue;

public interface UserService {

  public boolean isDeplicated(MailAddressValue mailAddress);

}
