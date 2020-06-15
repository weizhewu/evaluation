package com.soft1851.evaluation.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.soft1851.evaluation.repository.ListRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/6/9 9:05
 * @Description:
 */
public class JsoupUtil {
    @Resource
    private ListRepository listRepository;
    /**
     *
     * @param url 访问路径
     * @return
     */
    public static Document getDocument (String url){
        try {
            //5000是设置连接超时时间，单位ms
            Document document =  Jsoup.connect(url).timeout(100000).get();
            if (document == null){
                System.out.println(url);
            }
            return Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getContent(String url){
        Document doc = JsoupUtil.getDocument(url);

        // 获取目标HTML代码
        Elements elements1 = doc.select("[class=answer-template]");
        if (elements1 == null){
            System.out.println(url);
        }

        //获取问答主体
        Elements questionContent = elements1.select("[class=question-content]");

        //获取问题名称
        Elements questionTitle = questionContent.select("[class=question-title]");

        List<String> list = new ArrayList<>();
        for (Element element : questionTitle){
            list.add(element.text());
        }
        return list;
    }

    public static List<String> getQuestion(List<String> urlList){
        List<String> result = new ArrayList<>();
        for (String s :urlList){
            Document doc = JsoupUtil.getDocument(s);

            // 获取目标HTML代码
            Elements elements1 = doc.select("[class=answer-template]");

            //获取问答主体
            Elements questionContent = elements1.select("[class=question-content]");

            //获取问题名称
            Elements questionTitle = questionContent.select("[class=question-title]");

            for (Element element : questionTitle){
                result.add(element.text());
            }
        }
        return result;
    }

    public static List<String> getAnswer(String url){
        Document doc = JsoupUtil.getDocument(url);
        List<String> result = new ArrayList<>();

        // 获取目标HTML代码
        Elements elements1 = doc.select("[class=answer-template]");

        //获取问答主体
        Elements questionContent = elements1.select("[class=question-content]");

        //获取答案选项
        Elements questionOption = questionContent.select("[class=question-option]");

        Elements matrix = questionOption.select("[class=matrix]");
        for (Element element : matrix){
            result.add(element.text());
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(JsoupUtil.getContent("https://www.wenjuan.com/lib_detail_full/5e4ceef6a320fc6fd5c68585"));
//        List<String> urlList = new ArrayList<>();
//        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\1.csv");
//        urlList.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\2.csv");
//        List<String> tem = CsvUtil.getQuestion();
//        for (String s : tem){
//            List<String> result = JsoupUtil.getContent(s);
//            for (String t : result){
//                System.out.println(t);
//            }
//        }
//        System.out.println(tem);
//        System.out.println(JsoupUtil.getQuestion(CsvUtil.getQuestion()));
        List<String> list = JsoupUtil.getContent("https://www.wenjuan.com/lib_detail_full/5e342724a320fc092a7707e9");
        for (int i = 0; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
//        String s3 = "总则编、无权编、合同编、人格权编、婚姻家庭编、继承编和侵权责任编七编 总则编、无权编、亲属编、继承编四编";
//        String [] spString = s3.split("\\s+");
//        for(String ss : spString){
//            System.out.println(ss);
//        }
    }

}
