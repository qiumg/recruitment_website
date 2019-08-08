package com.website.server.dao;

import com.website.server.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmpMapper {
    int deleteByPrimaryKey(Integer empNo);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empNo);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}