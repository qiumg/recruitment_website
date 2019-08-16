package com.website.server.dao;

import com.website.server.pojo.TicketInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TicketInfoMapper {
    int deleteByPrimaryKey(Integer ticId);

    int insert(TicketInfo record);

    int insertSelective(TicketInfo record);

    TicketInfo selectByPrimaryKey(Integer ticId);

    int updateByPrimaryKeySelective(TicketInfo record);

    int updateByPrimaryKey(TicketInfo record);
}