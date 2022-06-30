package com.nowcoder.community.service;

import com.nowcoder.community.entity.User;

public interface UserService {
    //根据用户id查询用户数据
    public User findUserById(int id);
}
