package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    //根据用户名来查询，用户名是唯一的
    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    /*
    以id为条件更新一些参数：状态、头像路径、密码
     */
    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
