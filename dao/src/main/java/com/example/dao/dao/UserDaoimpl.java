package com.example.dao.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.mp.mapperStu;
import com.example.entity.entity.User;
import com.example.entity.entity.UserDetailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * author:@song;
 * version:1.0;
 */
@Repository
public class UserDaoimpl implements  userDao{//如果再给dao 继承一个接口，会报错，
    @Autowired
    private mapperStu mp;


    public String setUser(User user) {//新增用户
        
        //如果存在相同的名字就不行
        QueryWrapper<User> ww=new  QueryWrapper<User>();
        ww.eq("name",user.getName());
        System.out.println(user.getName());
        long l = mp.selectCount(ww);
        if (l!=0){//说明这个名字存在了，提示换个名字
            return "名字已经被他人注册";
        }else {
            user.insert();
            return "注册成功";
        }

    }


    public User getUser(User user) {
        String name = user.getName();
        String password = user.getPassword();
        QueryWrapper<User> ww=new  QueryWrapper<User>();
        ww.eq("name",name);
        User user1 = user.selectOne(ww);
      if (user1!=null){//有这个名字的用户
          String password1 = user1.getPassword();
          if (password1.equals(password)) {//密码也一样，就返回这个对象
              return user1;
          }else {//密码不一样
              return null;
          }
      }//根据名字没查到用户 ，返回null
      return null;

    }


    @Override
    public UserDetailed selectUserDetailed(User user) {
        Integer id = user.getId();
        if(user.getUserDetailed()!=null){
            UserDetailed userDetailed = mp.selectUserDetailedUserDetailed(id);
            return userDetailed;
        }


        return null;
    }
}
