package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 11:25
 * @Description:
 */
public interface HomeService {
    /**
     * 根据id查询home
     * @param homeId 主键
     * @return ResponseResult
     */
    ResponseResult getById(int homeId);

    /**
     * 查询所有home
     * @return ResponseResult
     */
    ResponseResult getAll();
}
