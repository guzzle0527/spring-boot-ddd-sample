package com.example.ddd.infrastracture.h2.query;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.ddd.application.user.query.dto.UserQueryOutputDto;

@Mapper
interface UserQueryMapper {

  List<UserQueryOutputDto> selectAll();

}
