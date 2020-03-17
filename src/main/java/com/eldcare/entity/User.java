package com.eldcare.entity;

import lombok.Data;

/**
 * Author:ShiQi
 * Date:2020/3/12-10:47
 */
@Data
public class User {
    //用户名
    private String id;
    //密码
    private String password;
    //身份类型（1:护工；2:家属；3:院方）
    private Integer type;
    //注册时间
    private Long gmtCreate;
    //修改时间
    private Long gmtModified;

    public User() {
    }
}
