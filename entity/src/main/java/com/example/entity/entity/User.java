package com.example.entity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.entity.cfg.ObjectTypeHandler;
import org.springframework.stereotype.Repository;

/**
 * author:@song;
 * version:1.0;
 */

@Repository
@TableName(value="user", autoResultMap = true)
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String password;
    private String name;
    //指定具体的处理器
    @TableField(typeHandler = ObjectTypeHandler.class)
    private UserDetailed UserDetailed;
    public Integer getId() {
        return id;
    }

    public UserDetailed getUserDetailed() {
        return UserDetailed;
    }

    public void setUserDetailed(UserDetailed userDetailed) {
        UserDetailed = userDetailed;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", UserDetailed=" + UserDetailed +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public User() {

    }
    public User(String name, String password) {
        this.password = password;
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
