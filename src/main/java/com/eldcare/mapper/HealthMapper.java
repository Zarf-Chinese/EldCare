package com.eldcare.mapper;

import com.eldcare.model.Health;
import com.eldcare.model.HealthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HealthMapper {
    long countByExample(HealthExample example);

    int deleteByExample(HealthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Health record);

    int insertSelective(Health record);

    List<Health> selectByExample(HealthExample example);

    Health selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Health record, @Param("example") HealthExample example);

    int updateByExample(@Param("record") Health record, @Param("example") HealthExample example);

    int updateByPrimaryKeySelective(Health record);

    int updateByPrimaryKey(Health record);
}