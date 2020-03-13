package entity;

/**
 * 家属
 */

public class FamMember {
    /** 家人id */
    // 主键，与t_elder的id字段形成外键约束：添加的家属必须对应老人
    private int id;
    /** 家人姓名 */
    private String name;
    /**
     * 所有老人id，以 ',' 间隔。如 "123,245,555"
     */
    private String elderIdList;

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

    public String getElderIdList() {
        return elderIdList;
    }

    public void setElderIdList(String elder_id_list) {
        this.elderIdList = elder_id_list;
    }
}