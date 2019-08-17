package com.website.server.service;

import com.website.server.pojo.UserProjectexp;

public interface ProjectexpService {
    public UserProjectexp showProjectexp(String resumeName);
    public boolean addProjectexp(UserProjectexp userProjectexp);
}
