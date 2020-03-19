package com.eldcare.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zarf
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID")
    private String id;

    @TableField("PASSWORD")
    private String password;

    @TableField("TYPE")
    private Integer type;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Integer getType() {
        return type;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    @TableField("GMT_CREATE")
    private Long gmtCreate;

    @TableField("GMT_MODIFIED")
    private Long gmtModified;


}
