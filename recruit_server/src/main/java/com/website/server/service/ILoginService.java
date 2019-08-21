package com.website.server.service;

import com.website.server.pojo.CompanySignLogin;
import com.website.server.pojo.User;

public interface ILoginService {
    User queryUserByEmail(User record);

    String insertUserByEmail(User record);

    CompanySignLogin queryComByEmail(CompanySignLogin record);

    String insertComByEmail(CompanySignLogin record);
}
