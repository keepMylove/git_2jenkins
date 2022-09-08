package com.example.dao.mp;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.entity.User;
import com.example.entity.entity.UserDetailed;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface mapperStu extends BaseMapper<User> {

    @Select("select t.* from user  c, userdetailed t where c.user_detailed=t.id and c.id= #{id}")
    public UserDetailed selectUserDetailedUserDetailed(int id);//新增用户登录

    @Update("UPDATE user a,userdetailed b SET a.name=b.name, a.password=b.password WHERE a.id = b.id  ")
    //修改，个人详情
    public UserDetailed upUser(int id);
}
