package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.HomeChoice;
import com.soft1851.evaluation.util.JsoupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

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

    @Test
    void save(){
        List<String> answers = JsoupUtil.getAnswer("https://www.wenjuan.com/lib_detail_full/5e342724a320fc092a7707e9");
        for (int i = 0;i < answers.size(); i++){
            String answer = answers.get(i);
            String [] choices = answer.split("\\s+");
            for (int j = 0; j < choices.length; j++){
                HomeChoice homeChoice = HomeChoice.builder()
                        .content(choices[j])
                        .build();
                homeChoiceRepository.save(homeChoice);
            }
        }
    }
}