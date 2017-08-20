package com.yh.demo.webwiththymeleaf.repository;

import com.yh.demo.webwiththymeleaf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * web-with-thymeleaf-UserRepo
 * 用户管理数据库操作接口
 *
 * @author yh
 * @since 0.0.1 2017-08-20 11:32
 */
public interface UserRepo extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByUserNameOrEmail(String username, String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set outDate=:outDate, validateCode=:validateCode where email=:email")
    int setOutDateAndValidataCode(@Param("outDate") String outDate,
                                  @Param("validateCode") String validateCode,
                                  @Param("email") String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set passWord=:passWord where email=:email")
    int setNewPassword(@Param("passWord") String passWord, @Param("email") String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set description=:description where email=:email")
    int setDescription(@Param("description") String description, @Param("email") String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set userName=:userName where email=:email")
    int setUserName(@Param("userName") String userName, @Param("email") String email);
}
