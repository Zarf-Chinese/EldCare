package com.eldcare.model;

public class Elder {
    private Integer id;

    private Integer bid =-1;

    private String name="待填写";

    private Integer age=0;

    private Long gmtModified;

    public Elder(Integer id, Integer bid, String name, Integer age, Long gmtModified) {
        this.id = id;
        this.bid = bid;
        this.name = name;
        this.age = age;
        this.gmtModified = gmtModified;
    }

    public Elder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}