package com.website.server.service;

import com.website.server.pojo.UserWorks;

public interface WorksService {
    public UserWorks showUserworks(String resumeName);
    public boolean addUserworks(UserWorks userWorks);
}
