package com.website.server.service;

import com.website.server.pojo.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {
    public void modifyStatic(User user,String state,Integer id) throws Exception;

    public List<User> selectAll() throws Exception;

    public List<User> findUsers(String name, Integer sex , Integer age, Integer beginAge, Integer endAge, Integer workingYears, Integer beginWorkingYears, Integer endWorkdingYears, String state ) throws Exception;
}
