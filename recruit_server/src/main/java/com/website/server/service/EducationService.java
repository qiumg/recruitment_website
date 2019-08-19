package com.website.server.service;

import com.website.server.pojo.UserEducation;

public interface EducationService {
    public UserEducation showUseredu(String resumeName);
    public boolean addUseredu(UserEducation userEducation);
}
