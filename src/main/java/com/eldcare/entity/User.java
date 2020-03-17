package com.eldcare.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("PASSWORD")
    private String password;

    @TableField("TYPE")
    private Integer type;

    @TableField("GMT_CREATE")
    private Long gmtCreate;

    @TableField("GMT_MODIFIED")
    private Long gmtModified;


}
