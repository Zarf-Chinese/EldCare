package entity;

import java.sql.Date;

/**
 * 护工评价
 * 此表中的护工id和nurse表进行外键连接
 */
public class NurComment {

    /** 护工id */
    private int id;
    /** 评价家属id */
    private int famId;
    /**
     * 评价内容
     */
    private String content;
    /** 评价触发的服务器时间 */
    private Date time;


    public int getnurId() {
        return id;
    }

    public void setnurId(int targetNurId) {
        this.id = targetNurId;
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