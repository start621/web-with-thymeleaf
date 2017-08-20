package com.yh.demo.webwiththymeleaf;

import com.yh.demo.webwiththymeleaf.controller.UserController;
import com.yh.demo.webwiththymeleaf.domain.User;
import com.yh.demo.webwiththymeleaf.repository.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * web-with-thymeleaf-UserControllerTests
 * 用户管理controller测试
 *
 * @author yh
 * @since 0.0.1 2017-08-20 21:00
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration

public class UserControllerTests {

    @Autowired
    private UserRepo userRepo;

    private MockMvc mvc;
    private static final String BASE_PATH = "/userManagement/users";

    @Before
    public void init() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testGetUsers() throws Exception{
        userRepo.save(new User("aa", "aa123456", "aa@126.com", new Date()));
        userRepo.save(new User("bb", "bb123456", "bb@126.com", new Date()));
        userRepo.save(new User("cc", "cc123456", "cc@126.com", new Date()));
        mvc.perform(MockMvcRequestBuilders.get(BASE_PATH).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
