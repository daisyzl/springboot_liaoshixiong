package com.imooc.enums;

import javax.persistence.criteria.CriteriaBuilder;


public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
/*
1.一个java源文件最多只能定义一个public访问权限的枚举类
2.枚举类不能继承其它父类，也不能派生其它子类
3.枚举类的构造器只能使用private，如果省略了，默认使用private
4.枚举类的所有实例必须在枚举类的第一行显式列出
5.所有枚举类用，隔开，枚举值列举结束后以英文分号作为结束。这些枚举值代表了该枚举类所有可能的实例
6.



 */
