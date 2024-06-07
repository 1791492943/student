package com.student.common;

import lombok.Data;

@Data
public class R<T> {

    private T data;
    private String msg;
    private int code;


    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setData(null);
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.setData(null);
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

}
