package entity;

import java.sql.Date;

/**
 * 护工评价
 * 此表中的护工id和nurse表进行外键连接
 */
public class NurComment {

    /** 护工id */
    private int nurId;
    /** 评价家属id */
    private int famId;
    /**
     * 评价内容
     */
    private String content;
    /** 评价触发的服务器时间
     * 数据库中类型：datetime
     * 格式：yyyy-MM-dd HH:mm:ss
     * */
    private Date time;

    //构造方法：
    public NurComment() {
    }

    public NurComment(int nurId, int famId, String content) {
        this.nurId = nurId;
        this.famId = famId;
        this.content = content;
    }
    //toString:


    @Override
    public String toString() {
        return "评价详情：【" +
                "护工ID：" + nurId +
                "，用户ID：" + famId +
                "，评价内容：" + content +
                "】";
    }

    public int getNurId() {
        return nurId;
    }

    public void setNurId(int nurId) {
        this.nurId = nurId;
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