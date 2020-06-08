package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.repository.HomeChoiceRepository;
import com.soft1851.evaluation.service.HomeChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:35
 * @Description:
 */
@Service
public class HomeChoiceServiceImpl implements HomeChoiceService {
    @Resource
    private HomeChoiceRepository homeChoiceRepository;
    @Override
    public ResponseResult getCode(List<Integer> idList) {
        int result = 0;
        for (int id : idList){
            try {
                result = result + homeChoiceRepository.getCodeByHomeChoiceId(id);
            } catch (NullPointerException e){
                return ResponseResult.failure(ResultCode.NPE);
            }
        }
        return ResponseResult.success(result);
    }
}
