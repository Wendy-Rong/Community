package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    //实现主页功能
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, Page page) {
        //插入分页功能
        //设置总共页数，初始页面，是不存在用户信息的
        page.setRows(discussPostService.findDiscussPostRows(0));
        //设置复用的路径，这个是给浏览器发送请求用的，所以要加上/
        page.setPath("/index");


        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        //使用一个map容器将所有的User和DiscussPost中的userId关联起来
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost discussPost : list) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("discussPost", discussPost);
                //根据userId获取User对象
                User user = userService.findUserById(discussPost.getUserId());
                map.put("user", user);
                //将这一对关联的对象放进list集合中
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "index";
    }
}
