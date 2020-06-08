package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.domain.model.HomeType;
import com.soft1851.evaluation.repository.HomeTypeRepository;
import com.soft1851.evaluation.service.HomeTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 14:03
 * @Description:
 */
@Service
public class HomeTypeServiceImpl implements HomeTypeService {
    @Resource
    private HomeTypeRepository homeTypeRepository;
    @Override
    public ResponseResult getByHomeId(int homeId) {
        List<HomeType> list = homeTypeRepository.getHomeTypeByHomeIdOrHomeTypeId(homeId,null);
        if (list.size() == 0){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(list.get(0));
    }

    @Override
    public ResponseResult getByHomeTypeId(int homeTypeId) {
        List<HomeType> list = homeTypeRepository.getHomeTypeByHomeIdOrHomeTypeId(null,homeTypeId);
        if (list.size() == 0){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(list);
    }
}
