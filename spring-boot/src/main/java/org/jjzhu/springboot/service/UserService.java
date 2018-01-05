package org.jjzhu.springboot.service;

import org.jjzhu.dao.UserDao;
import org.jjzhu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhujiajunup@163.com on 2017/7/4.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public User findByName(String name){
        return userDao.findByName(name);
    }
}
