package com.glodon.easyshow.api;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 0:04 2019/10/10
 */
public class JsonResult<T> {

    /**
     * 编码
     */
    private Integer code;
    private String message;
    private T data;

    public static JsonResult success() {
        JsonResult result = new JsonResult();
        return result;
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
}
