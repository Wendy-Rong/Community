package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiscussPostTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    //用户输入为null表示首页展示
    @Test
    public void testSelectAllDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectAllDiscussPosts(0, 0, 10);
        discussPosts.forEach(System.out::println);
    }

    @Test
    public void testSelectDiscussPostRows(){
        int discussPostRows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(discussPostRows);
    }

}
