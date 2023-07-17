package org.example.vo;

import lombok.Data;

@Data
public class Result {

    private int code;

    private Object object;

    private String message;

    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, Object object, String message) {
        this.code = code;
        this.object = object;
        this.message = message;
    }

    public static Result ok(String message) {
        Result result = new Result();
        result.setCode(200);
        result.setObject(null);
        result.setMessage(message);
        return result;
    }

    public static Result ok(Object object, String message) {
        Result result = new Result();
        result.setCode(200);
        result.setObject(object);
        result.setMessage(message);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setMessage("碰到了异常情况");
        result.setCode(400);
        result.setObject(null);
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(400);
        result.setObject(null);
        return result;
    }

    public static Result error(int code, String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        result.setObject(null);
        return result;
    }
}
