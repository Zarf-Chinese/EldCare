package com.eldcare.model;

public class User {
    private String name;

    private Integer id;

    private String password;

    private Integer type;

    private Long gmtCreate;

    private Long gmtModified;

    private String token;

    public User(String name, Integer id, String password, Integer type, Long gmtCreate, Long gmtModified, String token) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.token = token;
    }

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}