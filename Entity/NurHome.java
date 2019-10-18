/**
 * 院方
 */
public class NurHome {
    /** 院方id */
    private int id;
    /** 护工姓名 */
    private String name;
    /** 院方邮件 */
    private String mail_path;
    /** 院方联系方式 */
    private String tele_number;

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

    public String getMail_path() {
        return mail_path;
    }

    public void setMail_path(String mail_path) {
        this.mail_path = mail_path;
    }

    public String getTele_number() {
        return tele_number;
    }

    public void setTele_number(String tele_number) {
        this.tele_number = tele_number;
    }
}