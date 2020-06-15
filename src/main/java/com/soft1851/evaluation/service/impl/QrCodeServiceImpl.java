package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.service.QrCodeService;
import com.soft1851.evaluation.util.QrCodeUtil;
import org.springframework.stereotype.Service;

/**
 * @Author: zw_w
 * @Date: 2020/6/15 9:22
 * @Description:
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {
    @Override
    public ResponseResult getQrCode(String url) {
        String result;
        try {
            result = QrCodeUtil.generateQRCodepic(url);
        } catch (Exception e){
            return ResponseResult.failure(ResultCode.QrCode_FAIL,e.getMessage());
        }
        return ResponseResult.success(result);
    }
}
