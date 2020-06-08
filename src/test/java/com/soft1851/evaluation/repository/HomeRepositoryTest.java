package com.soft1851.evaluation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 11:10
 * @Description:
 */
@SpringBootTest
class HomeRepositoryTest {
    @Resource
    private HomeRepository homeRepository;
    @Test
    void test(){
        System.out.println(homeRepository.getByHomeId(1));
    }

}