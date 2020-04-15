package com.example.ddd.infrastracture.h2.repository.task;

import java.time.LocalDateTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.ddd.domain.model.task.TaskEntity;

@Mapper
public interface TaskMapper {

  int selectIdentity();

  int insert(@Param("task") TaskEntity taskEntity, @Param("now") LocalDateTime now);

  int selectCountByUserId(@Param("userId") int userId);

}
