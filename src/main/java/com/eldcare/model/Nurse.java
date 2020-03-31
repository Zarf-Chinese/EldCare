package com.eldcare.model;

public class Nurse {
    private Integer id;

    private Integer bid =-1;

    private String name="待填写";

    private String telephone="待填写";

    private Integer workAge=0;

    private Long gmtModified;

    public Nurse(Integer id, Integer bid, String name, String telephone, Integer workAge, Long gmtModified) {
        this.id = id;
        this.bid = bid;
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