package com.eldcare.enums;

/**
 * Author:ShiQi
 * Date:2020/3/12-11:01
 * 用户的枚举类型
 */
public enum UserTypeEnum {
    //1:院方;2:护工；3:家属；
    ELD_HOME(1),
    NURSE(2),
    FAMILY(3);
    private Integer type;
    UserTypeEnum(Integer type){this.type=type;}
    public Integer getType(){return type;}

}
