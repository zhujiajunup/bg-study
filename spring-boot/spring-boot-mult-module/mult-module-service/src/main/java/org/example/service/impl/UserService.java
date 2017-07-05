package org.example.service.impl;

import org.assertj.core.util.Preconditions;
import org.example.dao.UserDao;
import org.example.dao.entity.User;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzzhujiajun on 2017/7/5.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    UserDao userDao;
    @Override
    public boolean addUser(User user) {
        Preconditions.checkNotNull(user);
        Preconditions.checkNotNull(user.getName());
        Integer age = user.getAge();
        if(age < 0 && age > 200){
            throw new IllegalArgumentException("age illegal");
        }
        return userDao.addUser(user);
    }

    @Override
    public User findByName(String name) {

        return userDao.findByName(name);
    }
}
