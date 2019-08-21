package com.website.server.service;

import com.website.server.pojo.User;

public interface ILoginService {
    User queryUserByEmail(User record);

    String insertUserByEmail(User record);

    int updatePassword(User record);

    int updatePwd(User record);
}
