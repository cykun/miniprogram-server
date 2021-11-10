package com.cyquen.miniprogramserver.model;

public class Result {

    private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
    private Object data; // 数据
    private String msg; // 描述

    public Result() {
    }

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功，传入数据
    public static Result buildSuccess() {
        return new Result(0, null, null);
    }

    // 成功，传入数据
    public static Result buildSuccess(Object data) {
        return new Result(0, data, null);
    }

    // 失败，传入描述信息
    public static Result buildError(String msg) {
        return new Result(-1, null, msg);
    }

    // 失败，传入描述信息,状态码
    public static Result buildError(String msg, Integer code) {
        return new Result(code, null, msg);
    }

    // 成功，传入数据,及描述信息
    public static Result buildSuccess(Object data, String msg) {
        return new Result(0, data, msg);
    }

    // 成功，传入数据,及状态码
    public static Result buildSuccess(Object data, int code) {
        return new Result(code, data, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", data=" + data + ", msg=" + msg
                + "]";
    }
}
