package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.List;
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
    @Test
    void findById(){
        System.out.println(listRepository.findById(1));
        listRepository.findAll();
    }

    @Test
    void findFirst10ByType() {
        java.util.List<List> lists = listRepository.findHome();
        lists.forEach(s-> System.out.println(s));
    }

    @Test
    void findSpecial(){
        java.util.List<List> lists = listRepository.findSpecial();
        lists.forEach(s-> System.out.println(s));
    }

    @Test
    void findByTitle() {
        java.util.List<List> lists = listRepository.findByTitle("大学生");
        lists.forEach(s-> System.out.println(s));
    }

    @Test
    void findHomeByKeywords() {
        java.util.List<List> lists = listRepository.findHomeByKeywords("大学生");
        lists.forEach(s-> System.out.println(s));
    }
}