package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //查询所有帖子，要实现登录之后显示我的帖子，也要实现分页显示的功能
    List<DiscussPost> selectAllDiscussPosts(int userId,int offset,int limit);

    //查询一共有多少条数据
    // @Param注解用于给参数取别名，如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);
}
