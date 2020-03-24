package com.eldcare.model;

public class Manager {
    private Integer id;

    private String name;

    private String telephone;

    private String address;

    private Long gmtModified;

    public Manager(Integer id, String name, String telephone, String address, Long gmtModified) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.gmtModified = gmtModified;
    }

    public Manager() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}