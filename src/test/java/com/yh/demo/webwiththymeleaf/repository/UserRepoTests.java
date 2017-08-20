package com.yh.demo.webwiththymeleaf.repository;

import com.yh.demo.webwiththymeleaf.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * web-with-thymeleaf-UserRepoTests
 * 用户管理数据库接口测试
 *
 * @author yh
 * @since 0.0.1 2017-08-20 11:54
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTests {

    @Autowired
    private UserRepo userRepo;

    @Before
    public void init() {
        userRepo.save(new User("aa", "aa123456", "aa@126.com", new Date()));
        userRepo.save(new User("bb", "bb123456", "bb@126.com", new Date()));
        userRepo.save(new User("cc", "cc123456", "cc@126.com", new Date()));
    }

    @Test
    public void test() {
        Assert.assertEquals("aa", userRepo.findByUserName("aa").getUserName());
        Assert.assertEquals("bb", userRepo.findByUserName("bb").getUserName());
        Assert.assertEquals("cc", userRepo.findByUserName("cc").getUserName());
    }
}
