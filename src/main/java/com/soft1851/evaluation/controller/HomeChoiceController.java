package com.soft1851.evaluation.controller;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.service.HomeChoiceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:46
 * @Description:
 */
//@RestController
//@RequestMapping(value = "/api/homeChoice/")
public class HomeChoiceController {
    @Resource
    private HomeChoiceService homeChoiceService;

    @PostMapping(value = "result")
    public ResponseResult getResult(@RequestBody List<Integer> idList){
        return homeChoiceService.getCode(idList);
    }
}
