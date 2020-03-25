package com.eldcare.model;

public class Feedback {
    private Integer id;

    private Integer elder;

    private Integer nurse;

    private Integer score;

    private String content;

    private Long gmtCreate;

    private Boolean isAnon;

    private Boolean isChecked;

    private Long checkTime;

    public Feedback(Integer id, Integer elder, Integer nurse, Integer score, String content, Long gmtCreate, Boolean isAnon, Boolean isChecked, Long checkTime) {
        this.id = id;
        this.elder = elder;
        this.nurse = nurse;
        this.score = score;
        this.content = content;
        this.gmtCreate = gmtCreate;
        this.isAnon = isAnon;
        this.isChecked = isChecked;
        this.checkTime = checkTime;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getElder() {
        return elder;
    }

    public void setElder(Integer elder) {
        this.elder = elder;
    }

    public Integer getNurse() {
        return nurse;
    }

    public void setNurse(Integer nurse) {
        this.nurse = nurse;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Boolean getIsAnon() {
        return isAnon;
    }

    public void setIsAnon(Boolean isAnon) {
        this.isAnon = isAnon;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }
}