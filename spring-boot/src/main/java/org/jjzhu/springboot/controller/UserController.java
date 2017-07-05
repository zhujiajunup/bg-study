/*
package org.jjzhu.springboot.controller;

import org.jjzhu.springboot.entity.User;
import org.jjzhu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Created by hzzhujiajun on 2017/7/4.
 *//*

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/findByName")
    @ResponseBody
    public User findByName(@RequestParam(name = "name") String name){
        return userService.findByName(name);
    }
}
*/
