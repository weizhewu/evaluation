package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 10:04
 * @Description:
 */
public interface UserService {
    /**
     * 根据手机号登录
     * @param phone
     * @param verifyCode
     * @return
     */
    ResponseResult login(String phone,String verifyCode);
}
