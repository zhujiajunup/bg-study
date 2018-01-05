package org.jjzhu.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jjzhu.springboot.entity.User;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhujiajunup@163.com on 2017/7/3.
 */
@Mapper
@Configuration
public interface UserMapper {
    @Select("select from user where name=#{name}")
    User findByName(@Param("name") String name);
/*
    @Insert("insert into user(name, age) values (#{name}, #{age})")
    int insert(@Param("name")String name, @Param("age") Integer age);
*/

    @Insert("insert into user(name, password, roles) values (#{user.name}, #{user.password}, #{user.roles})")
    int insert(@Param("user") User user);
}
