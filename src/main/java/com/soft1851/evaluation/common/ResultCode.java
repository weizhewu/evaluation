package com.soft1851.evaluation.common;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 8:16
 * @Description:
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    DATA_NULL(20001,"查无此数据"),
    PHONE_NULL(20002,"手机号为空"),
    PHONE_NOT_LEGAL(20003,"手机号不合法"),
    USER_INSERT_FAIL(20004,"新增用户失败"),
    /* 各种异常的处理：30001-39999 */
    NPE(30001,"空指针异常"),
    /* 数据层错误：40001-49999 */
    QrCode_FAIL(40001,"二维码生成失败");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}