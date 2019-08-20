package com.website.server.service;

import com.website.server.pojo.UserJobexp;

public interface JobExpService {
    public UserJobexp showJobexp(Integer resumeId);
    public boolean addJobexp(UserJobexp userJobexp);
    public boolean alterJobexp(UserJobexp userJobexp);
}
