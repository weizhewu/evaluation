package com.soft1851.evaluation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/16 10:02
 * @Description:
 */
@SpringBootTest
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void findByPhone() {
        System.out.println(userRepository.findByPhone("84513") == null);
    }
}