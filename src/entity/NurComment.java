package entity;

import java.sql.Date;

/**
 * 护工评价
 */
public class NurComment {
    /** 护工id */
    // 设置自增主键
    private int id;
    /** 护工id */
    private int targetNurId;
    /** 评价家属id */
    private int famId;
    /**
     * 评价内容
     */
    private String content;
    /** 评价触发的服务器时间 */
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTargetNurId() {
        return targetNurId;
    }

    public void setTargetNurId(int targetNurId) {
        this.targetNurId = targetNurId;
    }

    public int getFamId() {
        return famId;
    }

    public void setFamId(int famId) {
        this.famId = famId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}