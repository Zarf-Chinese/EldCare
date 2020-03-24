package com.eldcare.model;

public class Health {
    private Integer id;

    private Integer nurse;

    private Integer elder;

    private Boolean isAbnormal;

    private String content;

    private Long gmtCreate;

    public Health(Integer id, Integer nurse, Integer elder, Boolean isAbnormal, String content, Long gmtCreate) {
        this.id = id;
        this.nurse = nurse;
        this.elder = elder;
        this.isAbnormal = isAbnormal;
        this.content = content;
        this.gmtCreate = gmtCreate;
    }

    public Health() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNurse() {
        return nurse;
    }

    public void setNurse(Integer nurse) {
        this.nurse = nurse;
    }

    public Integer getElder() {
        return elder;
    }

    public void setElder(Integer elder) {
        this.elder = elder;
    }

    public Boolean getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(Boolean isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}