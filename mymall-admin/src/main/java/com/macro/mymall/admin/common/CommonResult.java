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
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }


    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> fail(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> fail() {
        return fail(ResultCode.FAILED);
    }



    /**
     * 失败返回结果
     * @param resultCode 提示信息
     */
    public static <T> CommonResult<T> fail(ResultCode resultCode) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), resultCode.getMessage(), null);
    }
}
