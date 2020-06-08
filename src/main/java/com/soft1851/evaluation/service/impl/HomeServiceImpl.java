package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.domain.model.Home;
import com.soft1851.evaluation.repository.HomeRepository;
import com.soft1851.evaluation.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 11:27
 * @Description:
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private HomeRepository homeRepository;
    @Override
    public ResponseResult getById(int homeId) {
        Home home = homeRepository.getByHomeId(homeId);
        if (home == null){
            ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(home);
    }

    @Override
    public ResponseResult getAll() {
        return ResponseResult.success(homeRepository.findAll());
    }
}
