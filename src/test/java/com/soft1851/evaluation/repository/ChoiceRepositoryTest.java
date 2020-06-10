package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.Choice;
import com.soft1851.evaluation.util.CsvUtil;
import com.soft1851.evaluation.util.JsoupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;


/**
 * @Author: zw_w
 * @Date: 2020/6/9 21:10
 * @Description:
 */;
@SpringBootTest
class ChoiceRepositoryTest {
    @Resource
    private ChoiceRepository choiceRepository;

    @Test
    void test() throws Exception {
        int index = 0;
        List<String> urls = CsvUtil.getQuestion();
        for (int i = 0 ; i < urls.size(); i++){
            List<String> answers = JsoupUtil.getAnswer(urls.get(i));
            for (int j = 0;j < answers.size();j++){
                index ++ ;
                String answer = answers.get(j);
                String [] choices = answer.split("\\s+");
                for (int m = 0;m < choices.length; m++){
                    Choice choice = Choice.builder()
                            .content(choices[m])
                            .tem(index)
                            .build();
                    choiceRepository.save(choice);
                    System.out.println(choice);
                }
            }
        }
    }

    @Test
    void test1(){
        int index = 0;
        for (int i=0;i<5;i++){
            System.out.println("index：");
            index ++;
            System.out.println(index);
        }
    }

}