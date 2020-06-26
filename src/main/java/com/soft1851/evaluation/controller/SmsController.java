package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.service.RedisService;
import com.soft1851.evaluation.util.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/3 13:16
 * @Description:
 */
@RestController
@Slf4j
public class SmsController {
    @Resource
    private RedisService redisService;

    @PostMapping(value = "api/sms")
    public void sendSms(@Param("phone")String phone){
        String code = SmsUtil.send(phone);
        redisService.set(phone,code,2L);
    }

}
