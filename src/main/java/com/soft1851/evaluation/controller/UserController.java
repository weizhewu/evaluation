package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 14:26
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/user/")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping(value = "phone")
    public ResponseResult login(@RequestParam String phone){
        return userService.login(phone);
    }
}
