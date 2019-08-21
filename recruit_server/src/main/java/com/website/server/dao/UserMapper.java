package com.website.server.dao;

import com.website.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //根据id修改状态
    void updateUserStaticById(User user,String state,Integer id) throws Exception;
    //查所有
    List<User> selectAll() throws Exception;
    //根据姓名、年龄、工时、状态
    List<User> selectUsers(@Param("name") String name, @Param("sex") Integer sex, @Param("age") Integer age, @Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge ,@Param("workingYears") Integer workingYears , @Param("beginWorkingYears") Integer beginWorkingYears , @Param("endWorkingYears") Integer endWorkingYears , @Param("state") String state ) throws Exception;
}