package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.HelloDao;
import org.springframework.stereotype.Repository;

@Repository("helloDao")
public class HelloDaoImpl implements HelloDao {
    @Override
    public String test() {
        return "HelloDAO!";
    }
}
