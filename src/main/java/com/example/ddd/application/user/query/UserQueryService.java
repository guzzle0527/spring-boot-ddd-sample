package com.example.ddd.application.user.query;

import java.util.List;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;

public interface UserQueryService {

  List<UserQueryOutputDto> findAll();

}
