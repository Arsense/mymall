package com.macro.mymall.admin.common;

import lombok.Data;

/**
 * Rest Api 统一返回类
 * @author tangwei
 * @date 2019/10/15 17:14
 */
@Data
public class CommonResult<T> {
    /**
     * 错误码
     */
    private long code;
    /**
     * 错误描述
     */
    private String message;
    /**
     * 返回业务信息
     */
    private T data;

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(1,"成功", data);
    }

    /**
     * 调用失败
     * @param data
     */
    public static <T> CommonResult<T> fail(T data) {
        return new CommonResult<>(0,"失败", data);
    }
}
