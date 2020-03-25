package com.eldcare.model;

public class Nurse {
    private Integer id;

    private Integer in;

    private String name;

    private String telephone;

    private Integer workAge;

    private Long gmtModified;

    public Nurse(Integer id, Integer in, String name, String telephone, Integer workAge, Long gmtModified) {
        this.id = id;
        this.in = in;
        this.name = name;
        this.telephone = telephone;
        this.workAge = workAge;
        this.gmtModified = gmtModified;
    }

    public Nurse() {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}