package com.website.server.service;

import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;

public interface UserSimpleInfoService {
    public UserResume getresumeybyuid(Integer userid);
    public boolean setresumename(Integer userid);
    public User getuserinfo(Integer userid);
}
