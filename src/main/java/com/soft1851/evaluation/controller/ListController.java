package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.ListService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/10 14:17
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/list/")
public class ListController {
    @Resource
    private ListService listService;

    @PostMapping(value = "home")
    private ResponseResult getHome(){
        return listService.findHome();
    }


    @PostMapping(value = "special")
    private ResponseResult getSpecial(){
        return listService.findSpecial();
    }


    @PostMapping(value = "keywords/{title}")
    private ResponseResult searchByKeyWords(@PathVariable String title){
        return listService.findByTitle(title);
    }


    @PostMapping(value = "{id}")
    private ResponseResult getHome(@PathVariable Integer id){
        return listService.findByListId(id);
    }
}
