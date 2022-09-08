package com.example.contorller.controller;


import com.example.entity.entity.User;
import com.example.entity.entity.UserDetailed;
import com.example.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author:@song;
 * version:1.0;
 */
@Controller
public class login {
    @Autowired
    private UserService userService;



    @RequestMapping("/")
    public String login(){
        System.out.println("登录1");

        return "login";
    }
    @RequestMapping("/dl")
    @ResponseBody
    public String dl(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password, HttpSession session){
        User user1 = new User(name, password);
        User user = userService.getUser(user1);
        if (user!=null){
            session.setAttribute("user",user);
            return "1";//成功
        }

        return  "0";//密码或账号错误

    }
    @RequestMapping("/dlz")
    public String dlz(){
//如果你直接转发或者重定向是 没反应的，原因其实也不难,主要是servlet拿到的是ajax发送过来的request,
// 也就是说这个请求不是浏览器请求的,
// 而是ajax请求的,所以,servlet对request进行请求转发或重定向都不能影响浏览器的跳转…..
// 也就出现了我们遇到的请求转发和重定向失效的问题.
//
//解决问题 axios用这个方式跳转页面
//        .then(function (value){
//            alert(value.data);
//            location.href = "http://localhost:8080/dlz";吧浏览器路径改为跳转到controller
//        })

//不管正确还是错误,都应该返回一个值给ajax,让ajax去跳转或干其他的事.使用ajax本来就是为了局部刷新网页,而不是跳

        System.out.println("开始登录z");
        return "user";
    }
    @ResponseBody
    @RequestMapping("/zc")
    public String zc(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password, HttpSession session){
        System.out.println("开始注册");
        User user = new User(name,password);
        String s = userService.setUser(user);
        return s;
    }


    @RequestMapping("/UserDetailed")//获取用户详情
    @ResponseBody
    public UserDetailed dluser(HttpSession session){
        User user = (User) session.getAttribute("user");
        UserDetailed userDetailed = userService.selectUserDetailed(user);
        return userDetailed;
    }

    @RequestMapping("/Chat")
    public String test2( HttpSession httpSession){
        System.out.println("char");
        return "Chat";
    }
    @PostMapping ("/uname")
    @ResponseBody
    public String test2E(HttpSession httpSession, Model mm){
        String username = (String) httpSession.getAttribute("username");
        System.out.println("d"+username);
        return username;
    }

}
