package com.soft1851.evaluation.service;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.domain.model.Module;


/**
 * @Author: zw_w
 * @Date: 2020/6/22 10:36
 * @Description:
 */
public interface ModuleService {
    /**
     * 新增模板
     * @param module
     * @return
     */
    ResponseResult insert(Module module);

}
