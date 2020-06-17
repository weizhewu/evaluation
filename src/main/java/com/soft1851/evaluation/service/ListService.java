package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;


/**
 * @Author: zw_w
 * @Date: 2020/6/10 14:18
 * @Description:
 */
public interface ListService {
    /**
     * 首页展示20条数据
     * @return ResponseResult
     */
    ResponseResult findHome();

    /**
     * 首页模糊查询
     * @param keywords
     * @return
     */
    ResponseResult findHomeByKeywords(String keywords);

    /**
     * 疫情防控模块100条数据
     * @return ResponseResult
     */
    ResponseResult findSpecial();

    /**
     * 疫情防控模块模糊查询
     * @param keywords
     * @return
     */
    ResponseResult findSpecialByKeywords(String keywords);

    /**
     * 根据title模糊查询
     * @param title String
     * @return ResponseResult
     */
    ResponseResult findByTitle(String title);

    /**
     * 根据id查询模块
     * @param id Integer
     * @return ResponseResult
     */
    ResponseResult findByListId(Integer id);
}
