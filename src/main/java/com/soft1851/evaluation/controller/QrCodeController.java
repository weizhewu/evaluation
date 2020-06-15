package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.QrCodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/15 9:29
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/code/")
public class QrCodeController {
    @Resource
    private QrCodeService qrCodeService;
    @PostMapping(value = "QrCode")
    public ResponseResult getQrCode(@RequestParam String content){
        return qrCodeService.getQrCode(content);
    }
}
