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
    private String telNumber;
    /**个人照片路径*/
    private String nurPhoto;

//构造方法：


    public Nurse(int id, String nurPhoto) {//临时测试用
        this.id = id;
        this.nurPhoto = nurPhoto;
    }

    public Nurse() {
    }

    public Nurse(int id, String name, int nurHomeId, String elderIdList, String telNumber, String nurPhoto) {
        this.id = id;
        this.name = name;
        this.nurHomeId = nurHomeId;
        this.elderIdList = elderIdList;
        this.telNumber = telNumber;
        this.nurPhoto = nurPhoto;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    public String getNurPhoto() {
        return nurPhoto;
    }
    public void setNurPhoto(String nurPhoto) {
        this.nurPhoto = nurPhoto;
    }


}
