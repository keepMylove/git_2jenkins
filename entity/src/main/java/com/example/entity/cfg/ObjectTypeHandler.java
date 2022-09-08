package com.example.entity.cfg;


import com.example.entity.entity.UserDetailed;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author:@song;
 * version:1.0;
 */
//因为数据库列 的类型和 实体类的 属性类型不 匹配
//    数据库是 int    实体类是对象
//实现4个抽象方法，四个方法的作用就是数据库和实体类属性之间的转换格式；
// get的方法是将数据库的值转换成java的Object格式，set的方法作用相反；
    //我这里是把数据库的 值 自定义 转换为 UserDetailed对象的 id
  //还要配置 @TableName(value="user", autoResultMap = true)
//在字段上指定具体的处理器s
//@TableField(typeHandler = ObjectTypeHandler.class)
//private UserDetailed UserDetailed;

public class ObjectTypeHandler extends BaseTypeHandler<UserDetailed> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserDetailed parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getId());
    }

    @Override
    public UserDetailed getNullableResult(ResultSet rs, String columnName) throws SQLException {
       Integer UserDetailed_id= rs.getInt(columnName);
        if (UserDetailed_id != null) {
            UserDetailed userDetailed = new UserDetailed();
            userDetailed.setId(UserDetailed_id);

            return userDetailed;
        }
        return null;
    }

    @Override
    public UserDetailed getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer UserDetailed_id= rs.getInt(columnIndex);
        if (UserDetailed_id != null) {
            UserDetailed userDetailed = new UserDetailed();
            userDetailed.setId(UserDetailed_id);

            return userDetailed;
        }
        return null;
    }

    @Override
    public UserDetailed getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer UserDetailed_id= cs.getInt(columnIndex);
        if (UserDetailed_id != null) {
            UserDetailed userDetailed = new UserDetailed();
            userDetailed.setId(UserDetailed_id);

            return userDetailed;
        }
        return null;
    }


}
