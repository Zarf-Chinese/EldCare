/**
 * 用户
 */
public class User {
    /** 用户注册登录用的id */
    private String id;
    /** 用户注册登录用的密码 */
    private String password;
    /** 用户关联的身份的id */
    private String identity_id;
    /**
     * 用户身份类型。1:老人；2:家属；3:院方；4:护工
     */
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}