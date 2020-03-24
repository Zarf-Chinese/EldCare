package com.eldcare.mapper;

import com.eldcare.model.Elder;
import com.eldcare.model.ElderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElderMapper {
    long countByExample(ElderExample example);

    int deleteByExample(ElderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Elder record);

    int insertSelective(Elder record);

    List<Elder> selectByExample(ElderExample example);

    Elder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Elder record, @Param("example") ElderExample example);

    int updateByExample(@Param("record") Elder record, @Param("example") ElderExample example);

    int updateByPrimaryKeySelective(Elder record);

    int updateByPrimaryKey(Elder record);

    //查找全部
    List<Elder> selectAll();
}