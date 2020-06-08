package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 11:30
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/home/")
public class HomeController {
    @Resource
    private HomeService homeService;
    @PostMapping(value = "homeId")
    public ResponseResult getByHomeId(@RequestParam int homeId){
        return homeService.getById(homeId);
    }

    @PostMapping(value = "")
    public ResponseResult getAll(){
        return homeService.getAll();
    }
}
