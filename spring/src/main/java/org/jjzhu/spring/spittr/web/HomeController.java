package org.jjzhu.spring.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhujiajunup@163.com on 2017/7/11.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping( method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
