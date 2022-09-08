package com.example.entity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * author:@song;
 * version:1.0;
 */

@Repository
@TableName(value="userDetailed")
public class UserDetailed {//用户详细信息
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String head;
    private String password;
    private String sex;
    private Date date;
    private  String gxqm;//个性签名

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", id=" + id +
                ", gxqm='" + gxqm + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGxqm() {
        return gxqm;
    }

    public void setGxqm(String gxqm) {
        this.gxqm = gxqm;
    }
}
