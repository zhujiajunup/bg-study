package org.jjzhu.springboot.entity;

/**
 * Created by hzzhujiajun on 2017/7/3.
 */
public class User {
    public static String DEFAULT_ROLE = "USER";
    private Long id;

    private String name;

    private String password;

    private String roles = "USER";

    public User(){

    }
    public User(String name, String password){
        this(name, password, DEFAULT_ROLE);
    }

    public User(String name, String password, String roles){
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
