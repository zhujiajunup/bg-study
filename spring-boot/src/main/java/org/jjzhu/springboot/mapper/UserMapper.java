package org.jjzhu.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jjzhu.springboot.entity.User;

/**
 * Created by hzzhujiajun on 2017/7/3.
 */
//@Mapper
public interface UserMapper {
    @Select("select from user where name=#{name}")
    User findByName(@Param("name") String name);
/*
    @Insert("insert into user(name, age) values (#{name}, #{age})")
    int insert(@Param("name")String name, @Param("age") Integer age);
*/

    @Insert("insert into user(name, age) values (#{user.name}, #{user.age})")
    int insert(@Param("user") User user);
}
