package com.yh.demo.webwiththymeleaf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * web-with-thymeleaf-User
 * 用户模型
 *
 * @author yh
 * @since 0.0.1 2017-08-20 11:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String description;

    @Column(nullable = false)
    private Date createTime;

    @Column
    private Date lastModifyTime;

    @Column
    private String outDate;

    @Column
    private String validateCode;

    public User(String userName, String password, String email, Date createTime) {

        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
    }
}
