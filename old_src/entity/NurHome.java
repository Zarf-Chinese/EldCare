package entity;

/**
 * 院方
 */
/* 这个“院方”是什么意思？多个养老院共同管理？ */
public class NurHome {
    /** 院方id */
    private int id;
    /** 院方全称 */
    private String name;
    /** 院方邮件 */
    private String mailPath;
    /** 院方联系方式 */
    private String teleNumber;
    /** 院方照片 */
    private String image;
    /** 院方主页链接 */
    private String link;

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

    public String getMailPath() {
        return mailPath;
    }

    public void setMailPath(String mail_path) {
        this.mailPath = mail_path;
    }

    public String getTeleNumber() {
        return teleNumber;
    }

    public void setTeleNumber(String tele_number) {
        this.teleNumber = tele_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}