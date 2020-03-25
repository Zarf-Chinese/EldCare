package com.eldcare.mapper;

import com.eldcare.model.Nurse;
import com.eldcare.model.NurseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NurseMapper {
    long countByExample(NurseExample example);

    int deleteByExample(NurseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nurse record);

    int insertSelective(Nurse record);

    List<Nurse> selectByExample(NurseExample example);

    Nurse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByExample(@Param("record") Nurse record, @Param("example") NurseExample example);

    int updateByPrimaryKeySelective(Nurse record);

    int updateByPrimaryKey(Nurse record);

    //查找全部
    List<Nurse> selectAll();

    List<Nurse> selectBySearch(String search);
}