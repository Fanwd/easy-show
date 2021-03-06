package com.glodon.easyshow.result;

/**
 * @ClassName JsonResult
 * @Description 通用返回结果
 * @Author fanwd
 * @Date 2019/10/14 19:49
 **/
public class JsonResult<T> {

    private Integer code;
    private String message;
    private T data;
    private Throwable throwable;

    protected JsonResult(Integer code, String message, T data, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.throwable = throwable;
    }

    public static <T> JsonResult<T> success() {
        return success(null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(0, "success", data, null);
    }

    public static <T> JsonResult<T> error(Throwable throwable) {
        return new JsonResult<>(500, "error", null, throwable);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
