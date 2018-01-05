package org.example;

import org.example.dao.Application;
import org.example.dao.UserDao;
import org.example.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhujiajunup@163.com on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void insert(){
        User user = new User("Ducy", 20);
        userDao.addUser(user);
    }
}
