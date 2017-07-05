package org.example.dao.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hzzhujiajun on 2017/7/5.
 */

public class User {

    private Long id;
    private String name;
    private Integer age;

    public User(){}

    public User(String name, Integer age){
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
