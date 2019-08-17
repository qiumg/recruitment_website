package com.website.server.service;

import com.website.server.pojo.UserJobwant;

public interface JobWantService {
    public UserJobwant showJobwant(String resumeName);
    public boolean addJobwant(UserJobwant userJobwant);
}
