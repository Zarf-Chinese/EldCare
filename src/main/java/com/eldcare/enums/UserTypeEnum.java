package com.eldcare.enums;

/**
 * Author:ShiQi
 * Date:2020/3/12-11:01
 * 用户的枚举类型
 */
public enum UserTypeEnum {
    //1:护工；2:家属；3:院方
    NURSE(1),
    FAMILY(2),
    ELD_HOME(3);
    private Integer type;
    UserTypeEnum(Integer type){this.type=type;}
    public Integer getType(){return type;}

}
