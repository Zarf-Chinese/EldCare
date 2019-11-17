package entity;

/**
 * 护工
 */
public class Nurse {
    /** 护工id */
    // 设置自增主键
    private int id;
    /** 护工姓名 */
    private String name;
    /** 所在养老院id */
    private int nurHomeId;
    /**
     * 所有负责的老人id，以 ',' 间隔。如 "123,245,555"
     */
    private String elderIdList;
    /** 护工工作时的联系方式 */
    private String teleNumber;

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

    public int getNurHomeId() {
        return nurHomeId;
    }

    public void setNurHomeId(int nurHomeId) {
        this.nurHomeId = nurHomeId;
    }

    public String getElderIdList() {
        return elderIdList;
    }

    public void setElderIdList(String elderIdList) {
        this.elderIdList = elderIdList;
    }

    public String getTeleNumber() {
        return teleNumber;
    }

    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }

}