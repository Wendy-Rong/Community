package com.nowcoder.community;

import com.nowcoder.community.dao.HelloDao;
import com.nowcoder.community.service.HelloService;
import com.nowcoder.community.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {
        System.out.println(applicationContext);

        HelloDao helloDao = applicationContext.getBean(HelloDao.class);
        System.out.println(helloDao.test());//HelloDaoTwo!

        helloDao = applicationContext.getBean("helloDao", HelloDao.class);
        System.out.println(helloDao.test());//HelloDAO!
    }

    @Test
    public void testBeanManagement(){
        HelloService service = applicationContext.getBean(HelloService.class);
        System.out.println(service);

        service = applicationContext.getBean(HelloServiceImpl.class);
        System.out.println(service);
    }
}
