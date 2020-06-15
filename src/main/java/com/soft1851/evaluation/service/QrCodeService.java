package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;

/**
 * @Author: zw_w
 * @Date: 2020/6/13 15:38
 * @Description:
 */
public interface QrCodeService {
    /**
     * 根据前端传过来的链接生成二维码
     * @param url
     * @return
     */
    ResponseResult getQrCode(String url);
}
