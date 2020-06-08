package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 14:01
 * @Description:
 */
public interface HomeTypeService {
    /**
     * 根据homeId查询
     * @param homeId int
     * @return ResponseResult
     */
    ResponseResult getByHomeId(int homeId);

    /**
     * 根据honeTypeId查询
     * @param homeTypeId int
     * @return ResponseResult
     */
    ResponseResult getByHomeTypeId(int homeTypeId);
}
