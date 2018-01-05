package org.jjzhu.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by zhujiajunup@163.com on 2017/7/12.
 */
@Entity
public class User {
    enum ROLE{
        admin, user
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ROLE role;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
