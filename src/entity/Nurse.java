package entity;

/**
 * 护工
 */
public class Nurse {
    /** 护工id */
	//设置自增主键
    private int id;
    /** 护工姓名 */
    private String name;
    /** 所在养老院id */
    private int nur_home_id;
    /**
     * 所有负责的老人id，以 ',' 间隔。如 "123,245,555"
     */
    private String elder_id_list;
    /** 护工工作时的联系方式 */
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

    public int getNur_home_id() {
        return nur_home_id;
    }

    public void setNur_home_id(int nur_home_id) {
        this.nur_home_id = nur_home_id;
    }

    public String getElder_id_list() {
        return elder_id_list;
    }

    public void setElder_id_list(String elder_id_list) {
        this.elder_id_list = elder_id_list;
    }

    public String getTele_number() {
        return tele_number;
    }

    public void setTele_number(String tele_number) {
        this.tele_number = tele_number;
    }
}