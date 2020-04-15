package com.example.ddd.infrastracture.h2.query;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.ddd.application.user.query.UserQueryService;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryService {

  private final UserQueryMapper userQueryMapper;

  @Override
  public List<UserQueryOutputDto> findAll() {
    return this.userQueryMapper.selectAll();
  }

}
