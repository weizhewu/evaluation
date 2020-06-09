package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.util.CsvUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @Author: zw_w
 * @Date: 2020/6/9 9:04
 * @Description:
 */
@SpringBootTest
class ListRepositoryTest {
    @Resource
    private ListRepository listRepository;
    @Test
    void test() throws Exception {
        listRepository.saveAll(CsvUtil.getAll());
    }

}