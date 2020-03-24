package com.eldcare.model;

public class Elder {
    private Integer id;

    private Integer in;

    private String name;

    private Integer age;

    private Long gmtModified;

    public Elder(Integer id, Integer in, String name, Integer age, Long gmtModified) {
        this.id = id;
        this.in = in;
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

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
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