package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.dao.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by hzzhujiajun on 2017/7/5.
 */
@Repository
public interface UserDao {

    boolean addUser(@Param("user") User user);

    User findByName(@Param("name")String name);

}
