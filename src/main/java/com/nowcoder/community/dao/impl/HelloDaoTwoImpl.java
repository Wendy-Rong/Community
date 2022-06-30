package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.HelloDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class HelloDaoTwoImpl implements HelloDao {
    @Override
    public String test() {
        return "HelloDaoPrimary!";
    }
}
