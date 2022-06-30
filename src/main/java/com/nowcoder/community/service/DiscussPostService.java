package com.nowcoder.community.service;


import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;

import java.util.List;

public interface DiscussPostService {

    //查询所有帖子
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);
    //查询没有被拉黑的所有帖子的个数
    public int findDiscussPostRows(int userId);
}
