package com.eldcare.mapper;

import com.eldcare.model.Broadcast;
import com.eldcare.model.BroadcastExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BroadcastMapper {
    long countByExample(BroadcastExample example);

    int deleteByExample(BroadcastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Broadcast record);

    int insertSelective(Broadcast record);

    List<Broadcast> selectByExample(BroadcastExample example);

    Broadcast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Broadcast record, @Param("example") BroadcastExample example);

    int updateByExample(@Param("record") Broadcast record, @Param("example") BroadcastExample example);

    int updateByPrimaryKeySelective(Broadcast record);

    int updateByPrimaryKey(Broadcast record);
}