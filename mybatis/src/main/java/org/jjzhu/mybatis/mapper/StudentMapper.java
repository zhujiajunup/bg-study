/**
 * @(#)StudentMapper.java, 2017/7/25.
 * <p/>
 * Copyright 2017 ****, Inc. All rights reserved.
 * **** PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.jjzhu.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.jjzhu.mybatis.entity.Student;


public interface StudentMapper {

    Student getStudentById(int id);

    int addStudent(Student student);

    int updateStudentName(@Param("name") String name, @Param("id") int id);

    Student getStudentByIdWithClassInfo(int id);
}