package com.soft1851.evaluation.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/10 14:28
 * @Description:
 */
@SpringBootTest
class ListServiceTest {
    @Resource
    private ListService listService;

    @Test
    void findHome() {
        System.out.println(listService.findHome());
    }

    @Test
    void findSpecial() {
        System.out.println(listService.findSpecial());
    }

    @Test
    void findByTitle() {
        System.out.println(listService.findByTitle("大学生"));
    }

    @Test
    void findByListId() {
        System.out.println(listService.findByListId(2));
    }
}