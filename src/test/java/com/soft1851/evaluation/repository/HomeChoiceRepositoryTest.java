package com.soft1851.evaluation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/8 13:04
 * @Description:
 */
@SpringBootTest
class HomeChoiceRepositoryTest {
    @Resource
    private HomeChoiceRepository homeChoiceRepository;

    @Test
    void getCodeByHomeChoiceId() {
        System.out.println(homeChoiceRepository.getCodeByHomeChoiceId(1));
    }
}