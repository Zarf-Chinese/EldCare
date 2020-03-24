package com.eldcare.model;

public class Broadcast {
    private Integer id;

    private Integer creator;

    private String title;

    private String content;

    private Long gmtCreate;

    private Integer type;

    public Broadcast(Integer id, Integer creator, String title, String content, Long gmtCreate, Integer type) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.content = content;
        this.gmtCreate = gmtCreate;
        this.type = type;
    }

    public Broadcast() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}