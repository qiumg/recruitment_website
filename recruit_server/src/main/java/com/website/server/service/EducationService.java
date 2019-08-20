package com.website.server.service;

import com.website.server.pojo.UserEducation;

public interface EducationService {
    public UserEducation showUseredu(Integer resumeId);
    public boolean addUseredu(UserEducation userEducation);
    public boolean alterUseredu(UserEducation userEducation);
}
