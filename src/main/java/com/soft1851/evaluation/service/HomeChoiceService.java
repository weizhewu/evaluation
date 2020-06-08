package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:33
 * @Description:
 */
public interface HomeChoiceService {
    /**
     * 得到成绩
     * @param idList
     * @return
     */
    ResponseResult getCode(List<Integer> idList);
}
