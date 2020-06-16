package com.soft1851.evaluation.service.impl;

import com.soft1851.evaluation.common.ResponseResult;
import com.soft1851.evaluation.common.ResultCode;
import com.soft1851.evaluation.repository.ListRepository;
import com.soft1851.evaluation.service.ListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/6/10 14:21
 * @Description:
 */
@Service
public class ListServiceImpl implements ListService {
    @Resource
    private ListRepository listRepository;
    @Override
    public ResponseResult findHome() {
        List<com.soft1851.evaluation.domain.model.List> lists = listRepository.findHome();
        if (lists.size() == 0 ){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(lists);
    }

    @Override
    public ResponseResult findHomeByKeywords(String keywords) {
        List<com.soft1851.evaluation.domain.model.List> lists = listRepository.findHomeByKeywords(keywords);
        if (lists.size() == 0 ){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(lists);
    }

    @Override
    public ResponseResult findSpecial() {
        List<com.soft1851.evaluation.domain.model.List> lists = listRepository.findSpecial();
        if (lists.size() == 0 ){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(lists);
    }

    @Override
    public ResponseResult findByTitle(String title) {
        List<com.soft1851.evaluation.domain.model.List> lists = listRepository.findByTitle(title);
        if (lists.size() == 0 ){
            return ResponseResult.failure(ResultCode.DATA_NULL);
        }
        return ResponseResult.success(lists);
    }

    @Override
    public ResponseResult findByListId(Integer id) {
        com.soft1851.evaluation.domain.model.List list;
        try {
            list = listRepository.findByList_id(id);
        } catch (NullPointerException e){
            return ResponseResult.failure(ResultCode.NPE);
        }
        return ResponseResult.success(list);
    }
}
