package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.HomeTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 14:07
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/homeType/")
public class HomeTypeController {
    @Resource
    private HomeTypeService homeTypeService;

    @PostMapping(value = "/homeId")
    public ResponseResult getByHomeId(int homeId){
        return homeTypeService.getByHomeId(homeId);
    }

    @PostMapping(value = "/honeTypeId")
    public ResponseResult getByHomeTypeId(int homeTypeId){
        return homeTypeService.getByHomeTypeId(homeTypeId);
    }
}
