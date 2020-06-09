package com.soft1851.evaluation.repository;

import com.soft1851.evaluation.domain.model.One;
import com.soft1851.evaluation.util.CsvUtil;
import com.soft1851.evaluation.util.JsoupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 13:47
 * @Description:
 */
@SpringBootTest
class OneRepositoryTest {
    @Resource
    private OneRepository oneRepository;

    @Test
    void test() throws Exception {
        List<String> urls = CsvUtil.getQuestion();
        for (int i = 0;i < urls.size() ; i++){
            List<String> questions = JsoupUtil.getContent(urls.get(i));
            for (int j = 0; j < questions.size(); j++){
                String question = questions.get(j);
                int length = question.length();
                int status = 0;
                String result;
                if (length < 10){
                    result = question;
                } else {
                    result =question.substring(length-8, length);
                    if (result.contains("单选")){
                        status = 1;
                    }
                    if (result.contains("多选")){
                        status = 2;
                    }
                    if (result.contains("选填")){
                        status = 3;
                    }
                    One one = One.builder()
                            .question(question)
                            .status(status)
                            .list111(i+1)
                            .build();
                    oneRepository.save(one);
//                    System.out.println(i);
                }

            }
            System.out.println(i);
        }

    }

}