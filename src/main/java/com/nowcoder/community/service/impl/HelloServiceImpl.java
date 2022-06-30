package com.nowcoder.community.service.impl;

import com.nowcoder.community.dao.HelloDao;
import com.nowcoder.community.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope(value = "prototype")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public String testService(){
        return helloDao.test();
    }

    public HelloServiceImpl() {
        System.out.println("实例化。。。。。。。。");
    }


    @PostConstruct
    public void init() {
        System.out.println("初始化。。。。。。。。");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁。。。。。。。。");
    }
}
