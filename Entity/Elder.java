/**
 * 老人
 */
public class Elder {
    /** 老人Id */
    private int id;
    /** 老人姓名 */
    private String name;
    /** 养老院Id */
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