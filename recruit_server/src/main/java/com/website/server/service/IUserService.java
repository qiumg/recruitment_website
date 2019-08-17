package com.website.server.service;

import com.website.server.pojo.User;



public interface IUserService {
    String queryUserByEmail(User record);

    String insertUserByEmail(User record);
}
