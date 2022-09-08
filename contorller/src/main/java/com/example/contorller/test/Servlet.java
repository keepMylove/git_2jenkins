package com.example.contorller.test;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:@song;
 * version:1.0;
 */
@Controller
public class Servlet {
    @RequestMapping("/a")
    public String user(){
        User user = new User();
        user.setAge("122,ewfdfsdfs0");
        user.setNAME("GIT");
        return "a";
    }

    @RequestMapping("/2")
    @ResponseBody
    public String user2(){
        User user = new User();
        user.setAge("122,ewfdfsdfs0");
        user.setNAME("GIT");
        return "a";
    }
}
