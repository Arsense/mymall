package com.macro.mymall.admin.service;

import javax.validation.constraints.NotEmpty; /**
 * @author tangwei
 * @date 2019/10/18 18:40
 */
public interface UmsAdminService {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(@NotEmpty(message = "用户名不能为空") String username, @NotEmpty(message = "密码不能为空") String password);
}
