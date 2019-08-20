package com.website.server.service;

import com.website.server.pojo.UserWorks;

public interface WorksService {
    public UserWorks showUserworks(Integer resumeId);
    public boolean addUserworks(UserWorks userWorks);
    public boolean alterUserworks(UserWorks userWorks);
}
