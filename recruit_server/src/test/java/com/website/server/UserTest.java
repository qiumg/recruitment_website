package com.website.server;

import com.website.server.dao.UserMapper;
import com.website.server.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private DataSource dataSource;

    @Test
    public void updateTest() throws Exception {
//        User user = new User();
//        user.setId(1001);
//        user.setState("审核通过");
//        System.out.println(user);
//        userMapper.updateUserStaticById(user);
    }

    @Test
    public void selectAll() throws Exception {
        List<User> userList = userMapper.selectAll();
        System.out.println(userList);
    }
    @Test
    public void selectUsers() throws Exception {
        List<User> users = userMapper.selectUsers("",0,null,null,null,null,null,null,"违规");
        System.out.println(users);
    }

}
