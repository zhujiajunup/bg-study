package org.jjzhu.dao;

import org.apache.ibatis.annotations.Param;
import org.jjzhu.springboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by hzzhujiajun on 2017/7/4.
 */
@Repository
public interface UserDao {

    User findByName(@Param("name") String name);
}
