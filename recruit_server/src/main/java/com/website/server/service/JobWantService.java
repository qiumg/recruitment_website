package com.website.server.service;

import com.website.server.pojo.UserJobwant;

public interface JobWantService {
    public UserJobwant showJobwant(Integer resumeId);
    public boolean addJobwant(UserJobwant userJobwant);
    public boolean alterJobwant(UserJobwant userJobwant);
}
