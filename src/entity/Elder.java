package entity;

/**
 * 老人
 */
/* 需要功能：根据老人id查找所属护工，是不是应该添加一个nurseId属性？ */
public class Elder {
    /** 老人Id */
    // 设置自增主键，反馈给家属的信息表需包含主键，家属依靠老人id注册家属信息
    private int id;
    /** 老人姓名 */
    private String name;
    /** 养老院Id，建议设置成床位格式：层数-房间号-床位，如"02-04-01" */
    private String nurHomeId;
    /**
     * 出生日期。格式： yyyy-mm-dd。如 "1917-09-08"
     */
    private String birthdayTime;
    /**
     * 老人状况
     */
    private String state;

    // 构造方法：

    public Elder() {
    }

    public Elder(int id, String name, String nurHomeId, String birthday_time, String state) {
        this.id = id;
        this.name = name;
        this.nurHomeId = nurHomeId;
        this.birthdayTime = birthday_time;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNurHomeId() {
        return nurHomeId;
    }

    public void setNurHomeId(String nurHomeId) {
        this.nurHomeId = nurHomeId;
    }

    public String getBirthdayTime() {
        return birthdayTime;
    }

    public void setBirthdayTime(String birthday_time) {
        this.birthdayTime = birthday_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}