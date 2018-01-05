package org.jjzhu.springboot.service;

import org.jjzhu.dao.UserDao;
import org.jjzhu.springboot.entity.User;
import org.jjzhu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujiajunup@163.com on 2017/7/12.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByName(s);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String roles = user.getRoles();
        System.out.println(roles);
        for(String role : roles.split(",")) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
