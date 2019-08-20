package com.website.server.service;

import com.website.server.pojo.UserProjectexp;

public interface ProjectexpService {
    public UserProjectexp showProjectexp(Integer resumeId);
    public boolean addProjectexp(UserProjectexp userProjectexp);
    public boolean alterProjectexp(UserProjectexp userProjectexp);
}
