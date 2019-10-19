/**
 * 老人
 */
 /*需要功能：根据老人id查找所属护工，是不是应该添加一个nurseId属性？*/
/*然而我现在还不知道多层外键如何设置……*/
public class Elder {
    /** 老人Id */
	//设置自增主键，反馈给家属的信息表需包含主键，家属依靠老人id注册家属信息
    private int id;
    /** 老人姓名 */
    private String name;
    /** 养老院Id，建议设置成床位格式：层数-房间号-床位，如"02-04-01" */
    private int nur_home_id;
    /**
     * 出生日期。格式： yyyy-mm-dd。如 "1917-09-08"
     */
    private String birthday_time;
    /**
     * 老人状况
     */
    private String state;

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

    public String getBirthday_time() {
        return birthday_time;
    }

    public void setBirthday_time(String birthday_time) {
        this.birthday_time = birthday_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}