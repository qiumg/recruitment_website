package com.website.server.service;

import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;

public interface UserSimpleInfoService {
    public UserResume getresumeybyuid(Integer userid);
    public boolean setresumename(UserResume userResume);
    public boolean setintroduction(UserResume userResume);
    public User getuserinfo(Integer userid);
    public boolean setuserinfo(User user);
}
