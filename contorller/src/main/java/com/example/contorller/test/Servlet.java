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
    @ResponseBody
    public String user(){
        User user = new User();
        user.setAge("122,0");
        user.setNAME("GIT");
        return  user.toString();
    }
}
