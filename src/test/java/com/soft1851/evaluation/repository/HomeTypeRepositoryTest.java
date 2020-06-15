package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.Home;
import com.soft1851.evaluation.domain.model.HomeType;
import com.soft1851.evaluation.domain.model.One;
import com.soft1851.evaluation.util.JsoupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/11 9:22
 * @Description:
 */
@SpringBootTest
class HomeTypeRepositoryTest {
    @Resource
    private HomeTypeRepository homeTypeRepository;
    @Test
    void save(){
        List<String> questions = JsoupUtil.getContent("https://www.wenjuan.com/lib_detail_full/5e342724a320fc092a7707e9");
        for (int j = 0; j < questions.size(); j++){
            String question = questions.get(j);
            int status =2;
            HomeType homeType = HomeType.builder()
                    .question(question)
                    .status(status)
                    .build();
            homeTypeRepository.save(homeType);
            System.out.println(homeType);
//                    System.out.println(i);


        }
    }

}