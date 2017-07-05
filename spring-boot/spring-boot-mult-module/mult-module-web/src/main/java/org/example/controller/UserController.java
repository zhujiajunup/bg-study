package org.example.controller;

import org.example.dao.entity.User;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hzzhujiajun on 2017/7/5.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/add")
    @ResponseBody
    public String addUser(@RequestBody User user){
        try {
            userService.addUser(user);
        }catch (NullPointerException e){
            return "null point";
        }catch (IllegalArgumentException e){
            return "illegal argument";
        }
        return "ok";
    }
    @RequestMapping(value = "/findByName")
    @ResponseBody
    public User findByName(String name){

        return userService.findByName(name);
    }
}
