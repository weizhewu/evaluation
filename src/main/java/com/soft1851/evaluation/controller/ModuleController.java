package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.domain.model.Module;
import com.soft1851.evaluation.service.ModuleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/22 13:58
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/user/")
public class ModuleController {
    @Resource
    private ModuleService moduleService;

    @PostMapping(value = "insert")
    private ResponseResult insert(@RequestBody Module module){
        return moduleService.insert(module);
    }
}
