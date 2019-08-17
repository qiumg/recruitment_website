package com.website.server.service;

import com.website.server.pojo.UserJobexp;

public interface JobExpService {
    public UserJobexp showJobexp(String resumeName);
    public boolean addJobexp(UserJobexp userJobexp);
}
